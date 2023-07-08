package com.kenny.llmdemo.kpt.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ChatTranslatorRequest {
    @JsonProperty("model")
    private String model;
    @JsonProperty("messages")
    private List<Message> messages;

    public ChatTranslatorRequest(String model) {
        this.model = model;
        this.messages = new ArrayList<>();
    }

    public void createMessages(String sourceLanguageName, String targetLanguageName, String sourceText){
        String systemMessageContent = String.format("You are a language translator from %s to %s", sourceLanguageName, targetLanguageName);
        Message systemMessage = new Message("system", systemMessageContent);
        Message userMessage = new Message("user", sourceText);

        messages.add(systemMessage);
        messages.add(userMessage);
    }
}
