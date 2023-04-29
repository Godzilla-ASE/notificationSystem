package com.example.notificationsystem.dto;

import com.example.notificationsystem.constant.MessageType;

public class UserInfoDTO {
    private int userid_from;
    private int userid_to;
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUserid_from() {
        return userid_from;
    }

    public int getUserid_to() {
        return userid_to;
    }

    public void setUserid_from(int userid_from) {
        this.userid_from = userid_from;
    }

    public void setUserid_to(int userid_to) {
        this.userid_to = userid_to;
    }
}
