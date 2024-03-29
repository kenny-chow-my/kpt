package com.kenny.llmdemo.kpt.service;

import com.kenny.llmdemo.kpt.model.LanguagePair;
import com.kenny.llmdemo.kpt.model.Persona;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConfigService {

    public List<LanguagePair> mockLanguagePair(){
        LanguagePair lp1 = new LanguagePair();
        lp1.setId(UUID.fromString("a5d2149d-84ed-4977-867a-be1e130fbaf7"));
        lp1.setSourceLanguage("en");
        lp1.setTargetLanguage("id");
        lp1.setLabel("English to Bahasa Indonesia");

        LanguagePair lp2 = new LanguagePair();
        lp2.setId(UUID.fromString("6d65c38b-5a1a-425e-b732-ac39d1bf2a2d"));
        lp2.setSourceLanguage("en");
        lp2.setTargetLanguage("zh");
        lp2.setLabel("English to Chinese");

        LanguagePair lp3 = new LanguagePair();
        lp3.setId(UUID.fromString("cd8b02cd-fc43-491a-9028-4517ed1fd3e9"));
        lp3.setSourceLanguage("en");
        lp3.setTargetLanguage("de");
        lp3.setLabel("English to German");

        List<LanguagePair> lpList = List.of(lp1, lp2,lp3);
        return lpList;
    }

    public List<Persona> mockPersonas(){
        Persona p1 = new Persona(UUID.fromString("4692a5a9-df1c-40da-9b29-fa00ba210beb"),
                false,
                "Casual",
                "Casual everyday conversation",
                "casual");

        Persona p2 = new Persona(UUID.fromString("1a8c881f-c49e-4eea-af79-cc9be10e5d0c"),
                false,
                "Fast pace",
                "Fast paced speaker, potentially come off as rude",
                "efficient, fast paced at the expense of sounding rude");

        Persona p3 = new Persona(UUID.fromString("9e77b10c-0499-414f-acee-1df7b3a4edb8"),
                false,
                "Business formal",
                "Polite, professional formal business speaker",
                "polite, professional and formal business");

        Persona p4 = new Persona(UUID.fromString("370D4475-621B-4943-91CE-3F94535482F5"),
                false,
                "5 years old child",
                "Speak like a 5 years old child in Singapore",
                "5 years old child in a Kindergarten in Singapore");

        Persona p5 = new Persona(UUID.fromString("370D4475-621B-4943-91CE-3F94535482F5"),
                false,
                "8 years old child",
                "Speak like an 8 years old child in Singapore",
                "8 years old child in Primary 2 of Singapore");

        Persona p6 = new Persona(UUID.fromString("370D4475-621B-4943-91CE-3F94535482F5"),
                false,
                "15 years old teenager",
                "Speak like a 15 years old teenager in Singapore",
                "15 years old teenager in a secondary school of Singapore");

        List<Persona> personaList = List.of(p1, p2, p3, p4, p5, p6);
        return personaList;
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

        return found == null ? null : found.getSourceLanguage();

    }

    public String getTargetLanguage(UUID id){
        List<LanguagePair> languagePairs = this.getAllLanguagePairs();
        LanguagePair found = languagePairs.stream().
                filter(lp -> {
                    return lp.getId().equals(id);
                }).
                findFirst().orElse(null);

        return found == null ? null : found.getTargetLanguage();
    }


    public List<Persona> getAllPersonas(){
        return this.mockPersonas();
    }
}
