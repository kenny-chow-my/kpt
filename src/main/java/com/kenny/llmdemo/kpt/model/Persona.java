package com.kenny.llmdemo.kpt.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Persona {
    @JsonProperty("id")
    private UUID id = null;

    @JsonProperty("private")
    private boolean isPrivate = false;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("prompt")
    private String prompt;
}
