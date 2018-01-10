package com.wisn.protocol.response;

import com.wisn.protocol.ConstantValues;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 数据体长度，4+2+2+2+4+数据体（最小长度14 ）
 */
public class ResponseDecode extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        while (true) {
            if (byteBuf.readableBytes() >=14) {
                //防止socket 字节攻击
                if(byteBuf.readableBytes()> ConstantValues.bufferMaxLength){
                    byteBuf.skipBytes(byteBuf.readableBytes());
                }
                int readerIndex;
                while (true) {
                    readerIndex = byteBuf.readerIndex();
                    byteBuf.markReaderIndex();
                    if (byteBuf.readInt() == ConstantValues.MESSAGE_HEADTAG) {
                        break;
                    }
                    byteBuf.resetReaderIndex();
                    //略过一个字节
                    byteBuf.readByte();
                    if (byteBuf.readableBytes() < 14) {
                        return;
                    }
                }
                short module = byteBuf.readShort();
                short cmd = byteBuf.readShort();
                short resultCode = byteBuf.readShort();
                int length = byteBuf.readInt();
                if (length < 0) {
                    channelHandlerContext.channel().close();
                }
                if (length == 0) {
                    Response response = Response.valueOf(module, cmd, resultCode, null);
                    byteBuf.readerIndex(readerIndex);
                    list.add(response);
                    return;
                }
                if (byteBuf.readableBytes() < length) {
                    byteBuf.readerIndex(readerIndex);
                    return;
                }
                byte[] data = new byte[length];
                byteBuf.readBytes(data);
                Response response = Response.valueOf(module, cmd, resultCode, data);
                list.add(response);
            } else {
                break;
            }
        }
    }
}
