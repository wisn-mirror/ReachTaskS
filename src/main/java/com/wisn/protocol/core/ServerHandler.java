package com.wisn.protocol.core;

import com.google.protobuf.InvalidProtocolBufferException;
import com.wisn.entity.Message;
import com.wisn.exception.NoAuthException;
import com.wisn.module.constant.CmdId;
import com.wisn.module.constant.ModuleId;
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
        short result=0;
        try {
            Invoker invoker = InvokerHolder.getInvoker(request.getModule(), request.getCmd());
            if (invoker != null) {
                //判断权限
                EMessageMudule.EMessage eMessage = EMessageMudule.EMessage.parseFrom(request.getData());
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
                }
            }
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
        Response response = Response.valueOf(request);
        response.setResultCode(result);
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
