package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ai")
@Slf4j
public class AiController {
    @Autowired
    private AiService aiService;

    // @Autowired
    // private AiServiceByChatClient aiService;

    @PostMapping(
            value = "/chat-model",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String chatModel(@RequestParam("question") String question) {
        String answerText = aiService.generateText(question);
        return answerText;
    }
}
