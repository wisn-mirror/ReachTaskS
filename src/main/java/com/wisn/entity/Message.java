package com.wisn.entity;

/**
 * `messageid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '消息id',
 * `fromuserid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '发送者用户ID',
 * `targetuserid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '接收者用户ID',
 * `type` int(4) NOT NULL COMMENT '消息类型',
 * `status` int(2) NOT NULL COMMENT '消息状态',
 * `content` varchar(1000) NOT NULL COMMENT '手机号',
 * `createtime` bigint(13) NOT NULL COMMENT '创建时间',
 * `receivetime` bigint(13) NOT NULL COMMENT '接收时间'
 */
public class Message {
    private long messageid;
    private long fromuserid;
    private long targetuserid;
    private int messagetype;
    private int status;
    private String content;
    private long createtime;
    private long receivetime;

    public Message() {
    }

    public Message(long fromuserid, long targetuserid, int messagetype, int status, String content, long createtime, long receivetime) {
        this.fromuserid = fromuserid;
        this.targetuserid = targetuserid;
        this.messagetype = messagetype;
        this.status = status;
        this.content = content;
        this.createtime = createtime;
        this.receivetime = receivetime;
    }

    public long getMessageid() {
        return messageid;
    }

    public void setMessageid(long messageid) {
        this.messageid = messageid;
    }

    public long getFromuserid() {
        return fromuserid;
    }

    public void setFromuserid(long fromuserid) {
        this.fromuserid = fromuserid;
    }

    public long getTargetuserid() {
        return targetuserid;
    }

    public void setTargetuserid(long targetuserid) {
        this.targetuserid = targetuserid;
    }

    public int getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(int messagetype) {
        this.messagetype = messagetype;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    public long getReceivetime() {
        return receivetime;
    }

    public void setReceivetime(long receivetime) {
        this.receivetime = receivetime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageid=" + messageid +
                ", fromuserid=" + fromuserid +
                ", targetuserid=" + targetuserid +
                ", type=" + messagetype +
                ", status=" + status +
                ", content='" + content + '\'' +
                ", createtime=" + createtime +
                ", receivetime=" + receivetime +
                '}';
    }
}
