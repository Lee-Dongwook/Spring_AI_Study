package com.example.demo;

public class AiServiceMultiMessage {
    public String multiMessage(String question, List<Message> chatMemory) {
        SystemMessage systemMessage = SystemMessage.builder()
        .text("""
                당신은 AI 비서입니다.
                제공되는 지난 대화 내용을 보고 우선적으로 답변해 주세요.
                        """).build();
        
        if (chatMemory.size() == 0) {
            chatMemory.add(systemMessage);
        }

        log.info(chatMemory.toString());

        ChatResponse chatResponse = chatClient.prompt()
                .messages(chatMemory)
                .user(question)
                .call()
                .chatResponse();

        UserMessage userMessage = UserMessage
                .builder()
                .text(question)
                .build();
        
        chatMemory.add(userMessage);

        AssistanceMessage assistanceMessage = chatResponse
                .getResult()
                .getOutput();

        chatMemory.add(assistanceMessage);

        String text = assistanceMessage.getText();
        
        return text;
    }
}
