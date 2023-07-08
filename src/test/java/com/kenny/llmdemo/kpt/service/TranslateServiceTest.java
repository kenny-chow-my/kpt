package com.kenny.llmdemo.kpt.service;

import com.kenny.llmdemo.kpt.model.Translate;
import com.kenny.llmdemo.kpt.model.TranslateResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TranslateServiceTest {
    @Autowired
    private TranslateService translateService;


    @Test
    void translate() {
        Translate request = new Translate();
        request.setLanguagePairId(UUID.fromString("6d65c38b-5a1a-425e-b732-ac39d1bf2a2d"));
        request.setSourceText("This is a text to translate");

        String s1 = request.getSourceText();
        UUID languagePairId = request.getLanguagePairId();
        String sourceLanguage = "English";
        String targetLanguage = "Chinese";

        TranslateResponse resp = new TranslateResponse();
        resp.setLanguagePairId(languagePairId);
        resp.setSourceLanguage(sourceLanguage);
        resp.setTargetLanguage(targetLanguage);
        resp.setSourceText(s1);

        TranslateResponse response = this.translateService.translate(request);
        resp.setTranslatedText(response.getTranslatedText());
        System.out.println(response);
    }
}