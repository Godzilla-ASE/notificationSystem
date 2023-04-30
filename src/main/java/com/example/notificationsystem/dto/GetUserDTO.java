package com.example.notificationsystem.dto;


public class GetUserDTO {
    private Long id;

    private String username;

    private String password;

    private String birthday;

    private String token;

    private String creationDate;

    private String email;

    private String location;

    private String fans;

    private String followings;

    private String haters;

    private String avatarUrl;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public Long getId() {
        return id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}

