package com.wisn.entity;

/**
 * `userid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
 * `nickname` varchar(100) NOT NULL COMMENT '用户昵称',
 * `nameid` varchar(100) NOT NULL COMMENT '用户号',
 * `iconurl` varchar(100) NOT NULL COMMENT '用户头像',
 * `password` varchar(100) NOT NULL COMMENT '用户头像',
 * `passwordsh` varchar(100) NOT NULL COMMENT '用户头像',
 * `phonenumber` varchar(13) NOT NULL COMMENT '手机号',
 * `registertime` bigint(13) NOT NULL COMMENT '注册时间',
 * `lastlogintime` bigint(13) NOT NULL COMMENT '最后一次登录时间',
 */
public class User {
    private long userid;
    private String nickname;
    private String nameid;
    private String iconurl;
    private String password;
    private String encryption;
    private String phonenumber;
    private long registertime;
    private long lastlogintime;

    public User() {
    }

    public User(long userid, String nickname, String nameid, String iconurl, String password, String encryption, String phonenumber, long registertime, long lastlogintime) {
        this.userid = userid;
        this.nickname = nickname;
        this.nameid = nameid;
        this.iconurl = iconurl;
        this.password = password;
        this.encryption = encryption;
        this.phonenumber = phonenumber;
        this.registertime = registertime;
        this.lastlogintime = lastlogintime;
    }


    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNameid() {
        return nameid;
    }

    public void setNameid(String nameid) {
        this.nameid = nameid;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public long getRegistertime() {
        return registertime;
    }

    public void setRegistertime(long registertime) {
        this.registertime = registertime;
    }

    public long getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(long lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getIconurl() {
        return iconurl;
    }

    public void setIconurl(String iconurl) {
        this.iconurl = iconurl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryption() {
        return encryption;
    }

    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", nickname='" + nickname + '\'' +
                ", nameid='" + nameid + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", registertime=" + registertime +
                ", lastlogintime=" + lastlogintime +
                '}';
    }
}
