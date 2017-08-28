package com.bethany.model;

import java.util.Date;

public class Timg {
    private String id;

    private String imgtitle;

    private String imgtype;

    private String imgpath;

    private Date insdate;

    private String userid;

    private Integer sortv;

    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getImgtitle() {
        return imgtitle;
    }

    public void setImgtitle(String imgtitle) {
        this.imgtitle = imgtitle == null ? null : imgtitle.trim();
    }

    public String getImgtype() {
        return imgtype;
    }

    public void setImgtype(String imgtype) {
        this.imgtype = imgtype == null ? null : imgtype.trim();
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath == null ? null : imgpath.trim();
    }

    public Date getInsdate() {
        return insdate;
    }

    public void setInsdate(Date insdate) {
        this.insdate = insdate;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getSortv() {
        return sortv;
    }

    public void setSortv(Integer sortv) {
        this.sortv = sortv;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}