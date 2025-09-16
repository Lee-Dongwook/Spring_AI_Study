package com.example.demo;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AiServiceDefaultMethod {
    private ChatClient chatClient;

    public AiServiceDefaultMethod(ChatClient.Builder chatClientBuilder) {
        chatClient = chatClientBuilder.defaultSystem("적절한 감탄사, 웃음 등을 넣어서 친절하게 대화해 주세요.")
                .defaultOptions(ChatOptions.builder()
                        .temperature(1.0)
                        .maxTokens(300)
                        .build())
                .build();
    }

    public Flux<String> defaultMethod(String question) {
        Flux<String> response = chatClient
                .prompt()
                .user(question)
                .stream()
                .content();
        return response;
    }
}
