package com.kenny.llmdemo.kpt.client;

import com.kenny.llmdemo.kpt.config.OpenAIConfig;
import com.kenny.llmdemo.kpt.model.ChatResponse;
import com.kenny.llmdemo.kpt.model.ChatTranslatorRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "openai",
        url = "${openai.api.base-url}",
        configuration = OpenAIConfig.class
)
@Component
public interface OpenAIClient {

    @PostMapping(value = "${openai.api.url}", headers = {"Content-Type=application/json"})
    ChatResponse chat(@RequestBody ChatTranslatorRequest chatTranslatorRequest);
}
