package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ai")
@Slf4j
public class AiControllerMultiMessages {
    @Autowired
    private AiServiceMultiMessages aiService;

    @PostMapping(
        value = "/multi-messages",
        consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
        produces = MediaType.TEXT_PLAIN_VALUE        
    )
    public String multiMessages(@RequestParam("question") String question, HttpSession session) {
        List<Message> chatMemory = (List<Message>) session.getAttribute("chatMemory");
        
        if (chatMemory == null) {
            chatMemory = new ArrayList<Message>();
            session.setAttribute("chatMemory", chatMemory);
        }

        String answer = aiService.multiMessages(question, chatMemory);
        return answer;
    }
}
