package com.wisn.protocol.core;

import coder.request.Request;
import coder.response.Response;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ServerHandler extends SimpleChannelInboundHandler<Request> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Request request) throws Exception {
        System.out.println("ddd:"+request);
        Response  response=Response.valueOf((short)2,(short)2,(short)200,request.getData());
        channelHandlerContext.channel().writeAndFlush(response);
    }
}
