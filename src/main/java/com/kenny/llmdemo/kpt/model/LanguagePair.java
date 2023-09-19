package com.kenny.llmdemo.kpt.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * LanguagePair
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguagePair {
    @JsonProperty("id")
    private UUID id = null;

    @JsonProperty("sourceLanguage")
    private String sourceLanguage = null;

    @JsonProperty("targetLanguage")
    private String targetLanguage = null;

    @JsonProperty("label")
    private String label = null;

    public LanguagePair id(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LanguagePair sourceLanguage(String sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
        return this;
    }

    /**
     * Get sourceLanguage
     *
     * @return sourceLanguage
     **/

}
