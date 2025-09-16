package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ai")
@Slf4j
public class AiControllerDefaultMethod {
    @Autowired
    private AiServiceDefaultMethod aiService;

    @PostMapping(
        value = "/default-method",
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
        produces = MediaType.APPLICATION_NDJSON_VALUE
    )
    public Flux<String> defaultMethod(@RequestParam("question") String question) {
        Flux<String> response = aiService.defaultMethod(question);
        return response;
    }
}
