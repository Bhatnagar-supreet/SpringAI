package com.example.spring_ai_demo.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import org.springframework.ai.google.genai.GoogleGenAiChatOptions;

@Service
public class ChatService {

    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String ask(String question) {
        return chatClient
                .prompt()
                .user(question)
                .call()
                .content();
    }

    public String askWithContext(String question, String context) {
        return chatClient
                .prompt()
                .system(context )
                .user(question)
                .call()
                .content();
    }

    public String askWithOptions(String question) {
        return chatClient
                .prompt()
                .user(question)
                .options(GoogleGenAiChatOptions.builder()
                                .temperature(0.2)
                                .build())
                .call()
                .content();
    }
}