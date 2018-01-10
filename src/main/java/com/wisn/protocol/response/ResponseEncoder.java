package com.wisn.protocol.response;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 数据体长度，4+2+2+2+4+数据体（最小长度14 ）
 */
public class ResponseEncoder extends MessageToByteEncoder<Response> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Response request, ByteBuf byteBuf) throws Exception {
        byteBuf.writeInt(request.getTAG());
        byteBuf.writeShort(request.getModule());
        byteBuf.writeShort(request.getCmd());
        byteBuf.writeShort(request.getResultCode());
        int dataLength = request.getDataLength();
        byteBuf.writeInt(dataLength);
        if (dataLength != 0) {
            byteBuf.writeBytes(request.getData());
        }
    }
}
