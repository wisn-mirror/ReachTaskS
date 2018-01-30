package com.wisn.entity;

public class Moment {
    private long momentid;
    private long userid;
    private int status;
    private String content;
    private String imageres;
    private String videores;
    private String location;
    private long createtime;

    public Moment() {
    }

    public Moment(long momentid, long userid, int status, String content, String imageres, String videores, String location, long createtime) {
        this.momentid = momentid;
        this.userid = userid;
        this.status = status;
        this.content = content;
        this.imageres = imageres;
        this.videores = videores;
        this.location = location;
        this.createtime = createtime;
    }

    public long getMomentid() {
        return momentid;
    }

    public void setMomentid(long momentid) {
        this.momentid = momentid;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
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

    public String getImageres() {
        return imageres;
    }

    public void setImageres(String imageres) {
        this.imageres = imageres;
    }

    public String getVideores() {
        return videores;
    }

    public void setVideores(String videores) {
        this.videores = videores;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }
}
