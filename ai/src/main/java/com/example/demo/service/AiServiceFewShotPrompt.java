package com.example.demo;

public class AiServiceFewShotPrompt {
    public String fewShotPrompt(String order) {
        String strPrompt = """
                                    고객 주문을 유효한 JSON 형식으로 바꿔주세요.
                                    추가 설명은 포함하지 마세요.

                                    예시1:
                                    작은 피자 하나, 치즈랑 토마토 소스, 페퍼로니 올려서 주세요.
                                    JSON 응답:
                                    {
                                        "size" : "small",
                                        "type" : "normal",
                                        "ingredient" : ["cheese", "tomato sauce", "pepperoni"]
                                    }

                                    예시2:
                                    큰 피자 하나, 토마토 소스랑 바질, 모짜렐라 올려서 주세요.
                                    JSON 응답:
                                    {
                                        "size" : "large",
                                        "type" : "normal",
                                        "ingredient" : ["tomato sauce","basil","mozzarella"]
                                    }
                """;
        Prompt prompt = Prompt
                .builder()
                .content(strPrompt)
                .build();

        String pizzaOrderJson = chatClient.prompt(prompt)
                .options(
                        temperature(0.0)
                                .maxTokens(300)
                                .build())
                .call()
                .content();

        return pizzaOrderJson;
    }
}
