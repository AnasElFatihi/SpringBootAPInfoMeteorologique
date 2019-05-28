package com.emsi.backendpfa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class SocketController {

    private final SimpMessagingTemplate template;

    @Autowired
    SocketController(SimpMessagingTemplate template){
        this.template= template;
    }

    @MessageMapping("/send/message")
    public void messageRecu(String message)
    {
        this.template.convertAndSend("/chat",message);
    }
}
