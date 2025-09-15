package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AiService {
    @Autowired
    private ChatModel chatModel;

    public String generateText(String question) {
        SystemMessage systemMessage = SystemMessage.builder()
                .text("사용자 질문에 대해 한국어로 답변을 해야 합니다.")
                .build();
        UserMessage userMessage = UserMessage.builder()
            .text(question)
                .build();
        
        ChatOptions chatOptions = ChatOptions.builder()
            .model("gpt-4o-mini")
            .temperature(0.3)
            .maxTokens(1000)
            .build();
    
        Prompt prompt = Prompt.builder()
            .messages(systemMessage, userMessage)
            .chatOptions(chatOptions)
            .build();

        ChatResponse chatResponse = chatModel.call(prompt);
        AssistantMessage assistantMessage = chatResponse.getResult().getOutput();
        String answer = assistantMessage.getText();

        return answer;
    }
}
