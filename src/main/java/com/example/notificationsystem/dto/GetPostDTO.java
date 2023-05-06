package com.example.notificationsystem.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class GetPostDTO {
    private int id;
    private int userid;
    private String username;

    private String title;

    private String coverImage;

    private String content_text;

    private String content_img;

    private String tag;

    private int likeNum;

    private int unlikeNum;

    private List<Object> comment;

    private String url;

    private String location;

    private Date creation_date;
    private String like_users;
    private String unlike_users;
    private String user_avatar;

    public void setUser_avatar(String user_avatar) {
        this.user_avatar = user_avatar;
    }

    public String getUser_avatar() {
        return user_avatar;
    }

    public void setUnlike_users(String unlike_users) {
        this.unlike_users = unlike_users;
    }

    public void setLike_users(String like_users) {
        this.like_users = like_users;
    }

    public String getUnlike_users() {
        return unlike_users;
    }

    public String getLike_users() {
        return like_users;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getUserid() {
        return userid;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public int getUnlikeNum() {
        return unlikeNum;
    }

    public int getLikeNum() {
        return likeNum;
    }



    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUnlikeNum(int unlikeNum) {
        this.unlikeNum = unlikeNum;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUrl() {
        return url;
    }

    public String getTag() {
        return tag;
    }



    public String getContent_img() {
        return content_img;
    }

    public String getContent_text() {
        return content_text;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public String getTitle() {
        return title;
    }

    public void setContent_img(String content_img) {
        this.content_img = content_img;
    }

    public void setContent_text(String content_text) {
        this.content_text = content_text;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

