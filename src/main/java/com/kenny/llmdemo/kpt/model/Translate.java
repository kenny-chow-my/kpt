package com.kenny.llmdemo.kpt.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.UUID;

/**
 * Translate
 */

@Data
public class Translate {
    @JsonProperty("languagePairId")
    private UUID languagePairId = null;

    @JsonProperty("sourceText")
    private String sourceText = null;

    @JsonProperty("persona")
    private String persona = "casual";

}
