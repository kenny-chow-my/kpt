package com.kenny.llmdemo.kpt.service;

import com.kenny.llmdemo.kpt.client.OpenAIClient;
import com.kenny.llmdemo.kpt.config.OpenAIConfig;
import com.kenny.llmdemo.kpt.interceptor.HttpRequestResponseInterceptor;
import com.kenny.llmdemo.kpt.model.ChatTranslatorRequest;
import com.kenny.llmdemo.kpt.model.ChatResponse;
import com.kenny.llmdemo.kpt.model.Translate;
import com.kenny.llmdemo.kpt.model.TranslateResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class TranslateService {
    private static final Logger logger = LoggerFactory.getLogger(TranslateService.class);

    private LanguagePairService languagePairService;


    @Autowired
    private  OpenAIClient openAIClient;
    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;


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

        //{
        //    "model": "gpt-3.5-turbo",
        //    "messages": [{"role": "system", "content": "You are a language translator from English to Chinese"}, {"role": "user", "content": "This is a new world!"}]
        //  }

        // create a request
        ChatTranslatorRequest chatRequest = new ChatTranslatorRequest(model);
        chatRequest.createMessages(sourceLanguage, targetLanguage, s1);
        // call the API
        ChatResponse response = openAIClient.chat(chatRequest);

        logger.debug(response.toString());
        logger.debug("Response Id: " + response.getId());
        String answer = "";

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            answer = "No response";
        }
        else {
            answer = response.getChoices().get(0).getMessage().getContent();
        }

        resp.setTranslatedText(answer);
        return resp;
    }



}
