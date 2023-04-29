package com.example.notificationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class postRelatedNotification {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @GetMapping("/notification/likePost/{userid}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void likePost(@PathVariable int userid) {

        simpMessagingTemplate.convertAndSend("/topic/post/"+userid, "success!");

    }
}
