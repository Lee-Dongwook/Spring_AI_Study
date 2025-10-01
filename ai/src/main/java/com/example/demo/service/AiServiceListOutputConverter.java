package com.example.demo.service;

import java.util.List;
import java.util.Map;

public class AiServiceListOutputConverter {
    public List<String> listOutputConverterLowLevel(String city) {
        PromptTemplate promptTemplate = PromptTemplate.builder()
                .template("{city}에서 유명한 호텔 목록 5개를 출력하세요. {format}")
                .build();

        Prompt prompt = promptTemplate.create(
                Map.of("city", city, "format", converter.getFormat()));

        String commaSeparatedString = chatClient.prompt(prompt)
                .call()
                .content();

        List<String> hotelList = converter.convert(commaSeparatedString);
        return hotelList;
    }
    
      public List<String> listOutputConverterHighLevel(String city) {
        List<String> hotelList = chatClient.prompt()
                .user("%s에서 유명한 호텔 목록 5개를 출력하세요.".formatted(city))
                .call()
                .entity(new ListOutputConverter());
        return hotelList;
    }
}

