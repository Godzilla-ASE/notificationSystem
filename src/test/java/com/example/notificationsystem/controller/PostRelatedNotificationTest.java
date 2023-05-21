//package com.example.notificationsystem.controller;
//
//import com.example.notificationsystem.dto.GetMessageDTO;
//import com.example.notificationsystem.dto.UserInfoDTO;
//import com.example.notificationsystem.entity.Message;
//import com.example.notificationsystem.repository.MessageRepository;
//import com.example.notificationsystem.service.MessageService;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.aspectj.lang.annotation.Before;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.doNothing;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//@RunWith(MockitoJUnitRunner.class)
//public class PostRelatedNotificationTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private MessageService messageService;
//
//    @MockBean
//    SimpMessagingTemplate simpMessagingTemplate;
//
//    @MockBean
//    MessageRepository messageRepository;
//
//    @InjectMocks
//    private PostRelatedNotification postRelatedNotification;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(postRelatedNotification).build();
//    }
//
//    @Test
//    public void crateMessage_succeed() throws Exception {
//        UserInfoDTO userInfoDTO = new UserInfoDTO();
//        userInfoDTO.setUserid_to(1);
//        userInfoDTO.setUserid_from(2);
//
//        Message expectedMessage = new Message();
//        expectedMessage.setId(1);
//
//        Mockito.when(messageRepository.save(Mockito.any())).thenReturn(expectedMessage);
//
//        given(messageService.createMessage(Mockito.any())).willReturn(expectedMessage);
//
//        MockHttpServletRequestBuilder postRequest = post("/notification")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(userInfoDTO)).header(HttpHeaders.AUTHORIZATION,"12345678910");
//
//
//        mockMvc.perform(postRequest)
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void deleteMessage_succeed() throws Exception{
//
//        List<Message> messageList = new ArrayList<>();
//        Message message = new Message();
//        message.setId(10);
//        messageList.add(message);
//        UserInfoDTO userInfoDTO = new UserInfoDTO();
//        userInfoDTO.setUserid_to(1);
//        userInfoDTO.setUserid_from(2);
//
//        doNothing().when(messageRepository).delete(Mockito.any());
//
//        Mockito.when(messageRepository.findAll()).thenReturn(messageList);
//
//        doNothing().when(messageService).deleteMessage(Mockito.any());
//        MockHttpServletRequestBuilder deleteRequest = post("/notification/delete")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(asJsonString(userInfoDTO)).header(HttpHeaders.AUTHORIZATION,"12345678910");
//
//        mockMvc.perform(deleteRequest)
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void getMessages_succeed() throws Exception{
//        List<GetMessageDTO> getMessageDTOList = new ArrayList<>();
//        GetMessageDTO getMessageDTO = new GetMessageDTO();
//        getMessageDTO.setId(1);
//        getMessageDTOList.add(getMessageDTO);
//
//        List<Message> messageList = new ArrayList<>();
//        Message message = new Message();
//        message.setId(10);
//        messageList.add(message);
//
//        given(messageService.getMessages(Mockito.anyInt())).willReturn(messageList);
//        given(messageService.convertMessageToGet(Mockito.any())).willReturn(getMessageDTO);
//        Mockito.when(messageRepository.findByUserid(Mockito.anyInt())).thenReturn(messageList);
//
//        MockHttpServletRequestBuilder getRequest = get("/notification/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .header(HttpHeaders.AUTHORIZATION,"12345678910");
//
//        mockMvc.perform(getRequest)
//                .andExpect(status().isOk());
//
//    }
//
//    private String asJsonString(final Object object) {
//        try {
//            return new ObjectMapper().writeValueAsString(object);
//        } catch (JsonProcessingException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
//                    String.format("The request body could not be created.%s", e.toString()));
//        }
//    }
//}
