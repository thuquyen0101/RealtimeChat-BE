package com.example.reltimechatroom.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private Status status;

}
