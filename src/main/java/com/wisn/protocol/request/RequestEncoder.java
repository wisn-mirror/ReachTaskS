package com.wisn.protocol.request;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 数据包长度 4+2+2+4+数据体 最小长度12
 */
public class RequestEncoder extends MessageToByteEncoder<Request> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Request request, ByteBuf byteBuf) throws Exception {
        byteBuf.writeInt(request.getTAG());
        byteBuf.writeShort(request.getModule());
        byteBuf.writeShort(request.getCmd());
        int dataLength = request.getDataLength();
        byteBuf.writeInt(dataLength);
        if(dataLength!=0){
            byteBuf.writeBytes(request.getData());
        }
    }
}
