package com.kenny.llmdemo.kpt.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.UUID;
import org.springframework.validation.annotation.Validated;


/**
 * TranslateResponse
 */


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

  public TranslateResponse languagePairId(UUID languagePairId) {
    this.languagePairId = languagePairId;
    return this;
  }

  /**
   * Get languagePairId
   * @return languagePairId
   **/
    public UUID getLanguagePairId() {
    return languagePairId;
  }

  public void setLanguagePairId(UUID languagePairId) {
    this.languagePairId = languagePairId;
  }

  public TranslateResponse sourceLanguage(String sourceLanguage) {
    this.sourceLanguage = sourceLanguage;
    return this;
  }

  /**
   * Get sourceLanguage
   * @return sourceLanguage
   **/

    public String getSourceLanguage() {
    return sourceLanguage;
  }

  public void setSourceLanguage(String sourceLanguage) {
    this.sourceLanguage = sourceLanguage;
  }

  public TranslateResponse sourceText(String sourceText) {
    this.sourceText = sourceText;
    return this;
  }

  /**
   * Get sourceText
   * @return sourceText
   **/

    public String getSourceText() {
    return sourceText;
  }

  public void setSourceText(String sourceText) {
    this.sourceText = sourceText;
  }

  public TranslateResponse targetLanguage(String targetLanguage) {
    this.targetLanguage = targetLanguage;
    return this;
  }

  /**
   * Get targetLanguage
   * @return targetLanguage
   **/

    public String getTargetLanguage() {
    return targetLanguage;
  }

  public void setTargetLanguage(String targetLanguage) {
    this.targetLanguage = targetLanguage;
  }

  public TranslateResponse translatedText(String translatedText) {
    this.translatedText = translatedText;
    return this;
  }

  /**
   * Get translatedText
   * @return translatedText
   **/

    public String getTranslatedText() {
    return translatedText;
  }

  public void setTranslatedText(String translatedText) {
    this.translatedText = translatedText;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TranslateResponse translateResponse = (TranslateResponse) o;
    return Objects.equals(this.languagePairId, translateResponse.languagePairId) &&
        Objects.equals(this.sourceLanguage, translateResponse.sourceLanguage) &&
        Objects.equals(this.sourceText, translateResponse.sourceText) &&
        Objects.equals(this.targetLanguage, translateResponse.targetLanguage) &&
        Objects.equals(this.translatedText, translateResponse.translatedText);
  }

  @Override
  public int hashCode() {
    return Objects.hash(languagePairId, sourceLanguage, sourceText, targetLanguage, translatedText);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TranslateResponse {\n");
    
    sb.append("    languagePairId: ").append(toIndentedString(languagePairId)).append("\n");
    sb.append("    sourceLanguage: ").append(toIndentedString(sourceLanguage)).append("\n");
    sb.append("    sourceText: ").append(toIndentedString(sourceText)).append("\n");
    sb.append("    targetLanguage: ").append(toIndentedString(targetLanguage)).append("\n");
    sb.append("    translatedText: ").append(toIndentedString(translatedText)).append("\n");
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
