package com.wisn.test.client;


import com.wisn.protocol.protobuf.beans.EMessageMudule;
import com.wisn.protocol.request.Request;
import com.wisn.protocol.request.RequestEncoder;
import com.wisn.protocol.response.ResponseDecode;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
public class Client {
    private static ChannelFuture connect;
    private static Channel channel;

    public static void main(String[] args){
        NioEventLoopGroup nioEventLoopGroup =new NioEventLoopGroup(Runtime.getRuntime().availableProcessors()*2);
        Bootstrap bootstrap=new Bootstrap();
        bootstrap.group(nioEventLoopGroup);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline pipeline = socketChannel.pipeline();
                pipeline.addLast(new ResponseDecode());
                pipeline.addLast(new RequestEncoder());
                pipeline.addLast(new  ClientHandler());
            }
        });
        bootstrap.option(ChannelOption.SO_KEEPALIVE,true);
        try {
            connect = bootstrap.connect("127.0.0.1", 9999).sync();
            channel = connect.channel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long start = System.nanoTime();
        for(int i=0;i<10000;i++){
            EMessageMudule.EMessage eMessage = EMessageMudule.EMessage.newBuilder()
                    .setMessageid(i)
                    .setFromuserid(222)
                    .setTargetuserid(10000)
                    .setMessagetype(3)
                    .setStatus(-1)
                    .setContent("消息体")
                    .setCreatetime(System.currentTimeMillis())
                    .setReceivetime(-1).build();
            eMessage.toByteArray();
            Request request=Request.valueOf((short)1,(short)2,eMessage.toByteArray());

            channel.writeAndFlush(request);
        }
        System.out.println(System.nanoTime()-start);
    }
}
