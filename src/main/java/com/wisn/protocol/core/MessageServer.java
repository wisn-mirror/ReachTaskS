package com.wisn.protocol.core;

import com.wisn.protocol.request.RequestDecode;
import com.wisn.protocol.response.ResponseEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;

public class MessageServer {
    public static void start(String ip, int port) {
        ServerBootstrap bootstrap = new ServerBootstrap();
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(4);
        NioEventLoopGroup workGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors() * 2);
        NioEventLoopGroup businessGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors() * 2);
        bootstrap.group(bossGroup, workGroup);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                ChannelPipeline pipeline = socketChannel.pipeline();
                pipeline.addLast(new RequestDecode());
                pipeline.addLast(new ResponseEncoder());
                pipeline.addLast(businessGroup, new ServerHandler());
            }
        });
        System.out.println("============MessageServer Bind===============");
        ChannelFuture bind = bootstrap.bind(ip, port);
        try {
            bind.sync();
            System.out.println("============MessageServer Started===============");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
