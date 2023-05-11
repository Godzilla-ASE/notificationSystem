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

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/notification")
public class postRelatedNotification {
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    private MessageService messageService;

    public postRelatedNotification(MessageService messageService){
        this.messageService=messageService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void createMessage(@RequestBody UserInfoDTO userInfoDTO) {
        System.out.println(userInfoDTO.getUserid_to());
        Message message = messageService.createMessage(userInfoDTO);

        if(userInfoDTO.getUserid_to()!=userInfoDTO.getUserid_from()){
            simpMessagingTemplate.convertAndSend("/topic/post/"+userInfoDTO.getUserid_to(), messageService.convertMessageToGet(message, userInfoDTO));
            System.out.println("send success"+message.getUserid());
        }else{
            GetMessageDTO getMessageDTO = new GetMessageDTO();
            simpMessagingTemplate.convertAndSend("/topic/post/"+userInfoDTO.getUserid_to(),getMessageDTO);

        }
    }

    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void deleteMessage(@RequestBody UserInfoDTO userInfoDTO) {
        messageService.deleteMessage(userInfoDTO);
    }

    @GetMapping("/{userid}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<GetMessageDTO>> getMessages(@PathVariable int userid){
        List<Message> messageList = messageService.getMessages(userid);
        List<GetMessageDTO> result = new ArrayList<>();

        for(Message m: messageList){
            result.add(messageService.convertMessageToGet(m));
        }

        return ResponseEntity.ok(result);
    }
}
