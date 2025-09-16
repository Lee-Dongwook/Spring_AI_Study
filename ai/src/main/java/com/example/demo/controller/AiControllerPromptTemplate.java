package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ai")
@Slf4j
public class AiControllerPromptTemplate {
    @Autowired
    private AiServicePromptTemplate aiService;
    
    @PostMapping(
        value = "/prompt-template",
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
        produces = MediaType.APPLICATION_NDJSON_VALUE
    )
    public Flux<String> promptTemplate(
        @RequestParam("statement") String statement,
        @RequestParam("language") String language
    ) {
        Flux<String> response = aiService.promptTemplate1(statement, language);
        return response;
    }
}
