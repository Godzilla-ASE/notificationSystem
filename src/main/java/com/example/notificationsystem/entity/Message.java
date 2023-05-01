package com.example.notificationsystem.entity;

import com.example.notificationsystem.constant.MessageType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userid_from")
    private int userid_from;

    @Column(name = "userid_to")
    private int userid;

    @Column(name="type")
    private MessageType type;

    @Column(name="send_to_client_id")
    private int send_to_client_id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creation_date;

    public int getSend_to_client_id() {
        return send_to_client_id;
    }

    public MessageType getType() {
        return type;
    }

    public void setSend_to_client_id(int send_to_client_id) {
        this.send_to_client_id = send_to_client_id;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getUserid_from() {
        return userid_from;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setUserid_from(int userid_from) {
        this.userid_from = userid_from;
    }



}
