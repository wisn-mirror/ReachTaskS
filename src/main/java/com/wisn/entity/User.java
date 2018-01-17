package com.wisn.entity;


public class User {
    private long userid;
    private String nickname;
    private String nameid;
    private String iconurl;
    private String password;
    private String encryption;
    private String phonenumber;
    private String token;
    private long expired;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpired() {
        return expired;
    }

    public void setExpired(long expired) {
        this.expired = expired;
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
