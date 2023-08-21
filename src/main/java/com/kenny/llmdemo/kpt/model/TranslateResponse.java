package com.kenny.llmdemo.kpt.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;

import lombok.Data;
import org.springframework.validation.annotation.Validated;


/**
 * TranslateResponse
 */

@Data
public class TranslateResponse   {
  @JsonProperty("languagePairId")
  private UUID languagePairId = null;

  @JsonProperty("sourceLanguage")
  private String sourceLanguage = null;

  @JsonProperty("sourceText")
  private String sourceText = null;

  @JsonProperty("targetLanguage")
  private String targetLanguage = null;

  @JsonProperty("translatedText")
  private String translatedText = null;

  @JsonProperty("persona")
  private String persona = null;

}
