package com.baizhi.entity;

import java.util.Date;

public class Course {
    private String id;
    private String title;
    private String flag;
    private Date createTime;

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", flag='" + flag + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Course(String id, String title, String flag, Date createTime) {
        this.id = id;
        this.title = title;
        this.flag = flag;
        this.createTime = createTime;
    }

    public Course() {
    }
}
