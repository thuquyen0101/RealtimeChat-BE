package com.example.reltimechatroom.controller;

import com.example.reltimechatroom.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.SimpleMessageConverter;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    // SimpMessagingTemplate: send message tới các client thông qua websocket
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    // @Payload: nhận dữ liệu từ yêu cầu gửi đến và
    // chuyển đổi nó thành đối tượng Java để xử lý
    @MessageMapping("/message") // /app/message
    @SendTo("/chatroom/public")
    private Message receivePublicMessage(@Payload Message message){
        return message;
    }

    @MessageMapping("/private-message")
    public Message receivePrivateMessage(@Payload Message message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message);
        // /user/Quyen/private
        return message;
    }
}
