package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ai")
@Slf4j
public class AiControllerFewShotPrompt {
    @Autowired
    private AiServiceFewShotPrompt aiService;
    
    @PostMapping(
            value = "/few-shot-prompt",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String fewShotPrompt(@RequestParam("order") String order) {
        String json = aiService.fewShotPrompt(order);
        return json;
    }
}
