package com.wisn.protocol.core;

import com.google.protobuf.InvalidProtocolBufferException;
import com.wisn.exception.NoAuthException;
import com.wisn.protocol.module.constant.CmdId;
import com.wisn.protocol.module.constant.ModuleId;
import com.wisn.protocol.ResponseCode;
import com.wisn.protocol.core.scanner.Invoker;
import com.wisn.protocol.core.scanner.InvokerHolder;
import com.wisn.protocol.protobuf.beans.EMessageMudule;
import com.wisn.protocol.request.Request;
import com.wisn.protocol.response.Response;
import com.wisn.protocol.session.Session;
import com.wisn.protocol.session.SessionImpl;
import com.wisn.protocol.session.TokenEntity;
import com.wisn.protocol.session.TokenManager;
import com.wisn.tools.LogUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerHandler extends SimpleChannelInboundHandler<Request> {
    private static final String TAG ="ServerHandler" ;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Request request) throws Exception {
        handlerMessage(new SessionImpl(channelHandlerContext.channel()), request);
    }

    private void handlerMessage(Session session, Request request) {
        LogUtils.d(TAG,"request:"+request);
        EMessageMudule.EMessage eMessage=null;
        short result=0;
        try {
            Invoker invoker = InvokerHolder.getInvoker(request.getModule(), request.getCmd());
            if (invoker != null) {
                //判断权限
                eMessage = EMessageMudule.EMessage.parseFrom(request.getData());
                if (eMessage == null || eMessage.getToken() == null) {
                    throw new NoAuthException("没有认证");
                }
                System.out.println(eMessage.toMString()+ " token:"+eMessage.getToken()+"  content:"+eMessage.getContent());
                TokenEntity token = TokenManager.getToken(eMessage.getToken());
                if (token == null || token.isExpired()) {
                    throw new NoAuthException("没有认证");
                }
                if (token.getUserid() != eMessage.getFromuserid()) {
                    throw new NoAuthException("非法用户");
                }
                if (request.getModule() == ModuleId.AuthMessage && request.getCmd() == CmdId.AuthMessage.register) {
                    result= (short) invoker.invoke(session, eMessage);
                } else {
                    result= (short) invoker.invoke(eMessage);
                    sendTestCallBack(session,eMessage);
                }
                LogUtils.d(TAG,"result:"+result);
            }
            LogUtils.d(TAG,"result:"+invoker);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            result= ResponseCode.SERVER_EXCEPTION;
        }catch (NoAuthException e){
            e.printStackTrace();
            result= ResponseCode.NO_AUTH;
        }catch ( Exception e){
            e.printStackTrace();
            result= ResponseCode.SERVER_EXCEPTION;
        }
//        EMessageMudule.EMessage builder = EMessageMudule.EMessage.newBuilder()
//                .setMessageid(eMessage.getMessageid())
//                .setReceivetime(System.currentTimeMillis()).build();
//        //只需要消息id和接收时间
//        request.setData(builder.toByteArray());
        Response response = Response.valueOf(request);
        response.setResultCode(result);
        session.write(response);
        // TODO: 2018/2/2 用于测试测回执消息

    }
    public void sendTestCallBack(Session session, EMessageMudule.EMessage eMessage){
        EMessageMudule.EMessage build = EMessageMudule.EMessage.newBuilder()
                .setReceivetime(System.currentTimeMillis())
                .setMessageid(System.nanoTime())
                .setTargetuserid(eMessage.getFromuserid())
                .setFromuserid(eMessage.getTargetuserid())
                .setMessagetype(0)
                .setCreatetime(System.currentTimeMillis())
                .setStatus(1)
                .setToken("unknow")
                .setContent("测试回复"+eMessage.getContent())
                .build();
        Response response = Response.valueOf(ModuleId.chatMessage,CmdId.ChartMessage.sendMessageToOne, ResponseCode.newMessage,build.toByteArray() );
        session.write(response);
    }
    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
        LogUtils.d(TAG,"channelRegistered");
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        super.channelUnregistered(ctx);
        LogUtils.d(TAG,"channelUnregistered");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        LogUtils.d(TAG,"channelActive");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
        LogUtils.d(TAG,"channelInactive");
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx);
        LogUtils.d(TAG,"handlerAdded");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
        LogUtils.d(TAG,"handlerRemoved");
    }

}
