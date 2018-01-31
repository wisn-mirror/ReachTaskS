package com.wisn.entity;

import com.wisn.tools.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class Moment {
    private long momentid;
    private long userid;
    private int status;
    private String content;
    private String imageres;
    private String videores;
    private String location;
    private long createtime;
    private List<String> imagelist;
    private List<String> videolist;

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

    public List<String> getImagelist() {
        return imagelist;
    }

    public void addImage(String imge) {
        if(this.imagelist==null){
            this.imagelist=new ArrayList<>();
        }
      this.imagelist.add(imge);
    }


    public List<String> getVideolist() {
        return videolist;
    }

    public void addvideo(String videores) {
        if(this.videolist==null){
            this.videolist=new ArrayList<>();
        }
        this.videolist.add(videores);
    }

    public String arrayToString(List<Long> list) {
        if(list==null)return "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i));
            if (i != list.size() - 1) {
                builder.append(";");
            }
        }
        return builder.toString();
    }

    public List<Long> strToArray(String str) {
        if(TextUtils.isEmpty(str))return null;
        String[] split = str.split(";");
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(Long.parseLong(split[i]));
        }
        return list;
    }
}
