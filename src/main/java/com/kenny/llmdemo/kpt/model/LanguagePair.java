package com.kenny.llmdemo.kpt.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 * LanguagePair
 */


public class LanguagePair {
    @JsonProperty("id")
    private UUID id = null;

    @JsonProperty("sourceLanguage")
    private String sourceLanguage = null;

    @JsonProperty("targetLanguage")
    private String targetLanguage = null;

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


    public String getSourceLanguage() {
        return sourceLanguage;
    }

    public void setSourceLanguage(String sourceLanguage) {
        this.sourceLanguage = sourceLanguage;
    }

    public LanguagePair targetLanguage(String targetLanguage) {
        this.targetLanguage = targetLanguage;
        return this;
    }

    /**
     * Get targetLanguage
     *
     * @return targetLanguage
     **/


    public String getTargetLanguage() {
        return targetLanguage;
    }

    public void setTargetLanguage(String targetLanguage) {
        this.targetLanguage = targetLanguage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LanguagePair languagePair = (LanguagePair) o;
        return Objects.equals(this.id, languagePair.id) &&
                Objects.equals(this.sourceLanguage, languagePair.sourceLanguage) &&
                Objects.equals(this.targetLanguage, languagePair.targetLanguage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sourceLanguage, targetLanguage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LanguagePair {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    sourceLanguage: ").append(toIndentedString(sourceLanguage)).append("\n");
        sb.append("    targetLanguage: ").append(toIndentedString(targetLanguage)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
