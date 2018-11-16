package com.wisn.test.client;

import com.wisn.protocol.protobuf.beans.EMessageMudule;
import com.wisn.protocol.response.Response;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ClientHandler extends SimpleChannelInboundHandler<Response> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Response response) throws Exception {
        EMessageMudule.EMessage eMessage = EMessageMudule.EMessage.parseFrom(response.getData());
        System.out.println("response:"+eMessage.toMString());
        System.out.println(response);
    }
}
