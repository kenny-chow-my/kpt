package com.kenny.llmdemo.kpt.service;

import com.kenny.llmdemo.kpt.model.LanguagePair;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LanguagePairService {

    public List<LanguagePair> mockLanguagePair(){
        LanguagePair lp1 = new LanguagePair();
        lp1.setId(UUID.fromString("a5d2149d-84ed-4977-867a-be1e130fbaf7"));
        lp1.setSourceLanguage("en");
        lp1.setTargetLanguage("es");

        LanguagePair lp2 = new LanguagePair();
        lp2.setId(UUID.fromString("6d65c38b-5a1a-425e-b732-ac39d1bf2a2d"));
        lp2.setSourceLanguage("en");
        lp2.setTargetLanguage("zh");

        LanguagePair lp3 = new LanguagePair();
        lp3.setId(UUID.fromString("cd8b02cd-fc43-491a-9028-4517ed1fd3e9"));
        lp3.setSourceLanguage("es");
        lp3.setTargetLanguage("en");

        List<LanguagePair> lpList = List.of(lp1, lp2,lp3);
        return lpList;
    }
    public List<LanguagePair> getAllLanguagePairs(){
        return this.mockLanguagePair();

    }
    
    public String getSourceLanguage(UUID id){
        List<LanguagePair> languagePairs = this.getAllLanguagePairs();
        LanguagePair found = languagePairs.stream().
                filter(lp -> {
                    return lp.getId().equals(id);
                }).
                findFirst().orElse(null);
        if(found != null){
            return found.getSourceLanguage();
        }
        else{
            //always mock to english
            return "en";
        }
    }

    public String getTargetLanguage(UUID id){
        List<LanguagePair> languagePairs = this.getAllLanguagePairs();
        LanguagePair found = languagePairs.stream().
                filter(lp -> {
                    return lp.getId().equals(id);
                }).
                findFirst().orElse(null);
        if(found != null){
            return found.getTargetLanguage();
        }
        else{
            //always mock to english
            return "en";
        }
    }
}
