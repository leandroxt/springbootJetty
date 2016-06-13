package com.project.app.domain;

import java.util.Date;

/**
 * Created by leandro on 12/06/16.
 */
public class Post {

    private String id;

    private String title;

    private String picture;

    private Date date;

    public Post(String id, String title, String picture, Date date) {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.date = date;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
