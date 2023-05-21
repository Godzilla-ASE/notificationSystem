package com.example.notificationsystem.service;

import com.example.notificationsystem.constant.MessageType;
import com.example.notificationsystem.constant.ReceivedType;
import com.example.notificationsystem.dto.GetMessageDTO;
import com.example.notificationsystem.dto.GetPostDTO;
import com.example.notificationsystem.dto.GetUserDTO;
import com.example.notificationsystem.dto.UserInfoDTO;
import com.example.notificationsystem.entity.Message;
import com.example.notificationsystem.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MessageService {

    MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository){
        this.messageRepository=messageRepository;
    }

    private RestTemplate restTemplate = new RestTemplate();


    public Message createMessage(UserInfoDTO userInfoDTO){
        Message message = new Message();

        message.setUserid_from(userInfoDTO.getUserid_from());

        // System.out.println("in service"+userInfoDTO.getUserid_to());
        message.setUserid(userInfoDTO.getUserid_to());
        message.setType(MessageType.valueOf(userInfoDTO.getType()));
        message.setCreation_date(new Date());
        message.setSend_to_client_id(userInfoDTO.getSend_to_client_id());

        return messageRepository.save(message);
    }

    public GetMessageDTO convertMessageToGet(Message message, UserInfoDTO userInfoDTO){
        GetMessageDTO getMessageDTO=new GetMessageDTO();

        getMessageDTO.setId(message.getId());
        getMessageDTO.setSend_to_client_id(message.getSend_to_client_id());
        getMessageDTO.setType(message.getType());
        getMessageDTO.setUserid_from(message.getUserid_from());
        getMessageDTO.setUserid_to(message.getUserid());
        getMessageDTO.setCreation_date(message.getCreation_date());

        getMessageDTO.setUserAvatar_from(getUserInfo(message.getUserid_from()).getAvatarUrl());
        getMessageDTO.setUserAvatar_to(getUserInfo(message.getUserid()).getAvatarUrl());
        getMessageDTO.setUsername_from(getUserInfo(message.getUserid_from()).getUsername());
        getMessageDTO.setUsername_to(getUserInfo(message.getUserid()).getUsername());

        getMessageDTO.setSend_to_client(userInfoDTO.getSend_to_client());

//        if(message.getType()==MessageType.COMMENT){
//            getMessageDTO.setSend_to_client(restTemplate.postForObject(URL_COMMENT + "" + message.getSend_to_client_id(), null, String.class));
//        }else if(message.getType()==MessageType.REPLY){
//            getMessageDTO.setSend_to_client(restTemplate.postForObject(URL_REPLY + "" + message.getSend_to_client_id(), null, String.class));
//        } else if (message.getType()==MessageType.LIKE_POST) {
//            getMessageDTO.setSend_to_client(restTemplate.postForObject(URL_POST + "" + message.getSend_to_client_id(), null, String.class));
//        }

        return getMessageDTO;

    }

    public GetMessageDTO convertMessageToGet(Message message){
        GetMessageDTO getMessageDTO=new GetMessageDTO();

        getMessageDTO.setId(message.getId());
        getMessageDTO.setSend_to_client_id(message.getSend_to_client_id());
        getMessageDTO.setType(message.getType());
        getMessageDTO.setUserid_from(message.getUserid_from());
        getMessageDTO.setUserid_to(message.getUserid());
        getMessageDTO.setCreation_date(message.getCreation_date());

        getMessageDTO.setUserAvatar_from(getUserInfo(message.getUserid_from()).getAvatarUrl());
        getMessageDTO.setUserAvatar_to(getUserInfo(message.getUserid()).getAvatarUrl());
        getMessageDTO.setUsername_from(getUserInfo(message.getUserid_from()).getUsername());
        getMessageDTO.setUsername_to(getUserInfo(message.getUserid()).getUsername());

//        getMessageDTO.setSend_to_client("666");

        if(message.getType()==MessageType.COMMENT){
            getMessageDTO.setSend_to_client(restTemplate.getForObject("http://post:8082/comments/internal/" + message.getSend_to_client_id(), String.class));
        }else if(message.getType()==MessageType.REPLY){
            getMessageDTO.setSend_to_client(restTemplate.getForObject("http://post:8082/comments/reply/" + message.getSend_to_client_id(), String.class));
        } else if (message.getType()==MessageType.LIKE_POST) {
            GetPostDTO getPostDTO = restTemplate.getForObject("http://post:8082/posts/" + message.getSend_to_client_id(), GetPostDTO.class);
            getMessageDTO.setSend_to_client(getPostDTO.getTitle());
        }

        return getMessageDTO;

    }

    public GetUserDTO getUserInfo(int id){
        GetUserDTO getUserDTO = restTemplate.getForObject("http://user:8080/users/" + id, GetUserDTO.class);
        return getUserDTO;
//        GetUserDTO getUserDTO = new GetUserDTO();
//        getUserDTO.setAvatarUrl("image");
//        getUserDTO.setUsername("user1");
//
//        return getUserDTO;
    }

    public List<Message> getMessages(int userid){
        if(messageRepository.findByUserid(userid)!=null){
            return messageRepository.findByUserid(userid);
        }else {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No Messages");
        }
    }

    public void deleteMessage(UserInfoDTO userInfoDTO){
        List<Message> messageList = messageRepository.findAll();

        for(Message m:messageList){
            if(m.getUserid() == userInfoDTO.getUserid_to()
                    && m.getUserid_from() == userInfoDTO.getUserid_from()
                    && m.getType() == MessageType.valueOf(userInfoDTO.getType())
                    && m.getSend_to_client_id() == userInfoDTO.getSend_to_client_id()){
                messageRepository.delete(m);
            }
        }
    }
}
