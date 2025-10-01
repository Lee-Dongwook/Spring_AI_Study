package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ai")
@Slf4j
public class AiControllerZeroShotPrompt {
    @Autowired
    private AiServiceZeroShotPrompt aiService;

    @PostMessage(
            value = "/zero-shot-prompt",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    
    public String zeroShotPrompt(@RequestParam("review") String review) {
        String reviewSentiment = aiService.zeroShotPrompt(review);
        return reviewSentiment;
    }
}
