package com.kenny.llmdemo.kpt.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class Message {
    /**
     * Must be either 'system', 'user', 'assistant' or 'function'.<br>
     * You may use {@link ChatMessageRole} enum.
     */
    @NonNull
    String role;

    @JsonInclude() // content should always exist in the call, even if it is null
    String content;

    //name is optional, The name of the author of this message. May contain a-z, A-Z, 0-9, and underscores, with a maximum length of 64 characters.
    String name;

    public Message(String role, String content) {
        this.role = role;
        this.content = content;
        this.name = "kpt";
    }

    public Message(String role, String content, String name) {
        this.role = role;
        this.content = content;
        this.name = name;
    }

}
