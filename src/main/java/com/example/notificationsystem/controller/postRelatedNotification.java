package com.example.notificationsystem.controller;

import com.example.notificationsystem.constant.MessageType;
import com.example.notificationsystem.constant.ReceivedType;
import com.example.notificationsystem.dto.GetMessageDTO;
import com.example.notificationsystem.dto.UserInfoDTO;
import com.example.notificationsystem.entity.Message;
import com.example.notificationsystem.repository.MessageRepository;
import com.example.notificationsystem.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        GetMessageDTO getMessageDTO = new GetMessageDTO();

        simpMessagingTemplate.convertAndSend("/topic/post/"+userInfoDTO.getUserid_to(), message.getType());
    }

    @GetMapping("/notification/{userid}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<GetMessageDTO>> getMessages(@PathVariable int userid){
        List<>

    }
}
