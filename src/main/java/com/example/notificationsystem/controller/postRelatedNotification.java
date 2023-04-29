package com.example.notificationsystem.controller;

import com.example.notificationsystem.constant.MessageType;
import com.example.notificationsystem.constant.ReceivedType;
import com.example.notificationsystem.dto.UserInfoDTO;
import com.example.notificationsystem.entity.Message;
import com.example.notificationsystem.repository.MessageRepository;
import com.example.notificationsystem.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class postRelatedNotification {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    private MessageService messageService;

    public postRelatedNotification(MessageService messageService){
        this.messageService=messageService;
    }

    @PostMapping("/notification/likePost")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void createMessage(@RequestBody UserInfoDTO userInfoDTO) {
        Message message = messageService.createMessage(userInfoDTO);
        simpMessagingTemplate.convertAndSend("/topic/post/"+userInfoDTO.getUserid_to(), message.getType());
    }

    @GetMapping("/notification")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void getMessage(){

    }
}
