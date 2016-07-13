package com.project.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
public class Post implements Serializable {

    @Id
    @GeneratedValue
    private BigInteger id;

    private String title;

    private String subTitle;

    private Date datePost;

    private int mediaType;

    private User user;

    public Post() {
    }

    public Post(BigInteger id, String title, String subTitle, Date datePost, int mediaType, User user) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.datePost = datePost;
        this.mediaType = mediaType;
        this.user = user;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public int getMediaType() {
        return mediaType;
    }

    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format("Post[id=%d, mediaType='%s', user='%s']", this.getId(),
                this.getMediaType(), this.getUser().getId());
    }

    @Override
    public boolean equals(Object obj) {
        Post post = (Post) obj;
        if (this.getId().equals(post.getId())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
