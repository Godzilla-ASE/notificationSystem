package com.example.notificationsystem.service;

import com.example.notificationsystem.constant.MessageType;
import com.example.notificationsystem.constant.ReceivedType;
import com.example.notificationsystem.dto.UserInfoDTO;
import com.example.notificationsystem.entity.Message;
import com.example.notificationsystem.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public Message createMessage(UserInfoDTO userInfoDTO){
        Message message = new Message();

        message.setUserid_from(userInfoDTO.getUserid_from());
        message.setUserid_to(userInfoDTO.getUserid_to());
        message.setType(MessageType.valueOf(userInfoDTO.getType()));
        message.setResponse_message(ReceivedType.SUCCESS);

        return messageRepository.save(message);
    }
}
