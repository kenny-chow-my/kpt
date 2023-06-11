package com.kenny.llmdemo.kpt.service;

import com.kenny.llmdemo.kpt.model.Translate;
import com.kenny.llmdemo.kpt.model.TranslateResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TranslateService {
    private LanguagePairService languagePairService;



    public TranslateService(LanguagePairService languagePairService){
        this.languagePairService = languagePairService;
    }
    public TranslateResponse translate(Translate request){
        String s1 = request.getSourceText();
        UUID languagePairId = request.getLanguagePairId();
        String sourceLanguage = languagePairService.getSourceLanguage(languagePairId);
        String targetLanguage = languagePairService.getTargetLanguage(languagePairId);

        TranslateResponse resp = new TranslateResponse();
        resp.setLanguagePairId(languagePairId);
        resp.setSourceLanguage(sourceLanguage);
        resp.setTargetLanguage(targetLanguage);
        resp.setSourceText(s1);
        resp.setTranslatedText("Not yet implemented!");
        return resp;
    }
}
