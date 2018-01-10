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

public class Server {
    public static void main(String[] args) {
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
                pipeline.addLast(new ProtobufVarint32FrameDecoder());
                pipeline.addLast( new RequestDecode());
                pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
                pipeline.addLast( new ResponseEncoder());
                pipeline.addLast( businessGroup,new ServerHandler());
            }
        });
        ChannelFuture bind = bootstrap.bind("127.0.0.1", 9999);
        try {
            bind.sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
