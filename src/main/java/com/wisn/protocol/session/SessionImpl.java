package com.wisn.protocol.session;

import io.netty.channel.Channel;
import io.netty.util.AttributeKey;

public class SessionImpl implements Session {
    public static AttributeKey<Object> Attribute_Key = AttributeKey.valueOf("Attribute_Key");

    private Channel channel;

    public SessionImpl(Channel channel) {
        this.channel = channel;
    }

    @Override
    public Object getAttachment() {
        return channel.attr(Attribute_Key).get();
    }

    @Override
    public void setAttachment(Object attachment) {
        channel.attr(Attribute_Key).set(attachment);
    }

    @Override
    public void removeAttachment() {
        channel.attr(Attribute_Key).remove();
    }

    @Override
    public void write(Object message) {
        channel.writeAndFlush(message);
    }

    @Override
    public boolean isConnected() {
        return channel.isActive();
    }

    @Override
    public void close() {
        channel.close();
    }
}
