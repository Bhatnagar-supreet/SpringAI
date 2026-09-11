package com.example.spring_ai_demo.controller;


import org.springframework.web.bind.annotation.*;

import com.example.spring_ai_demo.services.ChatService;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping
    public String chat(@RequestParam String question) {

        return chatService.ask(question);
    }
}