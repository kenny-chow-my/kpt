package com.kenny.llmdemo.kpt.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 * Translate
 */

public class Translate {
    @JsonProperty("languagePairId")
    private UUID languagePairId = null;

    @JsonProperty("sourceText")
    private String sourceText = null;

    public Translate languagePairId(UUID languagePairId) {
        this.languagePairId = languagePairId;
        return this;
    }

    /**
     * Get languagePairId
     *
     * @return languagePairId
     **/


    public UUID getLanguagePairId() {
        return languagePairId;
    }

    public void setLanguagePairId(UUID languagePairId) {
        this.languagePairId = languagePairId;
    }

    public Translate translateText(String translateText) {
        this.sourceText = translateText;
        return this;
    }

    /**
     * Get translateText
     *
     * @return translateText
     **/
    public String getSourceText() {
        return sourceText;
    }

    public void setSourceText(String sourceText) {
        this.sourceText = sourceText;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Translate translate = (Translate) o;
        return Objects.equals(this.languagePairId, translate.languagePairId) &&
                Objects.equals(this.sourceText, translate.sourceText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languagePairId, sourceText);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Translate {\n");

        sb.append("    languagePairId: ").append(toIndentedString(languagePairId)).append("\n");
        sb.append("    translateText: ").append(toIndentedString(sourceText)).append("\n");
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
