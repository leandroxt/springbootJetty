package com.project.app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Date lastAccess;

    @Column(nullable = false)
    private Date becomeUser;

    @Column(nullable = false)
    private int isValid;

    private String token;

    public User() {

    }

    public User(Long id, String name, String username, String email, String password, Date lastAccess, Date becomeUser, int isValid, String token) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.lastAccess = lastAccess;
        this.becomeUser = becomeUser;
        this.isValid = isValid;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }

    public Date getBecomeUser() {
        return becomeUser;
    }

    public void setBecomeUser(Date becomeUser) {
        this.becomeUser = becomeUser;
    }

    public int getIsValid() {
        return isValid;
    }

    public void setIsValid(int isValid) {
        this.isValid = isValid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return String.format("Post[id=%d, userName='%s', email='%s']", this.getId(),
                this.getUsername(), this.getEmail());
    }

    @Override
    public boolean equals(Object obj) {
        User u = (User) obj;
        if (this.getId().equals(u.getId())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
