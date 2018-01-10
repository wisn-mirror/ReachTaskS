package com.wisn.protocol.session;

public interface Session {
    /**
     * 获取
     * @return
     */
    Object getAttachment();

    /**
     * 添加
     * @param attachment
     */
    void setAttachment(Object attachment);

    /**
     * 移除
     */
    void removeAttachment();

    /**
     * 写消息
     * @param message
     */
    void write(Object message);

    /**
     * 判断是否链接
     * @return
     */
    boolean isConnected();

    /**
     * 关闭
     */
    void close();
}
