package com.wisn.protocol.request;

import com.wisn.protocol.ConstantValues;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 数据体的最小长度 4+2+2+4=12
 */
public class RequestDecode extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        while (true) {

            if (byteBuf.readableBytes() >= 12) {
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
                    if (byteBuf.readableBytes() < 12) {
                        return;
                    }
                }
                short module = byteBuf.readShort();
                short cmd = byteBuf.readShort();
                int length = byteBuf.readInt();
                if (length < 0) {
                    //恶意包
                    channelHandlerContext.channel().close();
                }
                if(length==0){
                    Request request = Request.valueOf(module, cmd, null);
                    byteBuf.readerIndex(readerIndex);
                    list.add(request);
                    return;
                }
                //判断数据包是否完成
                if (byteBuf.readableBytes() < length) {
                    byteBuf.readerIndex(readerIndex);
                    return;
                }

                byte[] data = new byte[length];
                //读取数据体
                byteBuf.readBytes(data);
                Request request = Request.valueOf(module, cmd, data);
                list.add(request);
            } else {
                break;
            }
        }
    }
}
