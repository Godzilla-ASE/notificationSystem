package com.example.notificationsystem.entity;

import com.example.notificationsystem.constant.MessageType;
import com.example.notificationsystem.constant.ReceivedType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private int userid_to;

    @Column(name="type")
    private MessageType type;

    @Column(name="send_to_client_id")
    private int send_to_client_id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creation_date")
    private Date creation_date;
}
