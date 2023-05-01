package com.example.notificationsystem.dto;

import com.example.notificationsystem.constant.MessageType;
// import jakarta.persistence.Column;

import java.util.Date;

public class GetMessageDTO {
    private int id;

    private int userid_from;

    private int userid_to;

    private MessageType type;

    private int send_to_client_id;
    private String send_to_client;
    private String username_to;
    private String username_from;

    private String userAvatar_to;
    private String userAvatar_from;
    private Date creation_date;

    public void setUserAvatar_from(String userAvatar_from) {
        this.userAvatar_from = userAvatar_from;
    }

    public String getUserAvatar_from() {
        return userAvatar_from;
    }

    public void setUserid_to(int userid_to) {
        this.userid_to = userid_to;
    }

    public void setUserid_from(int userid_from) {
        this.userid_from = userid_from;
    }

    public int getUserid_to() {
        return userid_to;
    }

    public int getUserid_from() {
        return userid_from;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setUserAvatar_to(String userAvatar_to) {
        this.userAvatar_to = userAvatar_to;
    }

    public String getUserAvatar_to() {
        return userAvatar_to;
    }

    public void setUsername_to(String username_to) {
        this.username_to = username_to;
    }

    public void setUsername_from(String username_from) {
        this.username_from = username_from;
    }

    public String getUsername_to() {
        return username_to;
    }

    public String getUsername_from() {
        return username_from;
    }

    public MessageType getType() {
        return type;
    }

    public int getSend_to_client_id() {
        return send_to_client_id;
    }

    public String getSend_to_client() {
        return send_to_client;
    }

    public void setSend_to_client(String send_to_client) {
        this.send_to_client = send_to_client;
    }

    public void setSend_to_client_id(int send_to_client_id) {
        this.send_to_client_id = send_to_client_id;
    }
}
