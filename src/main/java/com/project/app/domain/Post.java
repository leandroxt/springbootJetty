package com.project.app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Entity
public class Post implements Serializable {

    @Id
    @GeneratedValue
    private BigInteger id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String subtitle;

    @Column(nullable = false)
    private Date postDate;

    @Column(nullable = false, name = "MEDIATYPE_ID")
    private int mediaType;

    @ManyToOne
    private User user;

    public Post() {
    }

    public Post(BigInteger id, String title, String subTitle, Date datePost, int mediaType, User user) {
        this.id = id;
        this.title = title;
        this.subtitle = subTitle;
        this.postDate = datePost;
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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Date getDatePost() {
        return postDate;
    }

    public void setDatePost(Date datePost) {
        this.postDate = datePost;
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
