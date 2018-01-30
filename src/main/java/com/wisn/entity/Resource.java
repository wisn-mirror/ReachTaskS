package com.wisn.entity;

public class Resource {
    private long resourceid;
    private int status;
    private int restype;
    private String imagepath;
    private long createtime;

    public Resource() {
    }

    public Resource(long resourceid, int status, int restype, String imagepath, long createtime) {
        this.resourceid = resourceid;
        this.status = status;
        this.restype = restype;
        this.imagepath = imagepath;
        this.createtime = createtime;
    }

    public long getResourceid() {
        return resourceid;
    }

    public void setResourceid(long resourceid) {
        this.resourceid = resourceid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRestype() {
        return restype;
    }

    public void setRestype(int restype) {
        this.restype = restype;
    }

    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }
}
