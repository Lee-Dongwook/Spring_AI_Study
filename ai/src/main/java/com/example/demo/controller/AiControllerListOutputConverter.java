package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.AiServiceListOutputConverter;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ai")
@Slf4j
public class AiControllerListOutputConverter {
    @Autowired
    private AiServiceListOutputConverter aiService;

    @PostMapping(
        value = "/list-output-converter",
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )

    public String listOutputConverter(@RequestParam("city") String city) {
    }
}
