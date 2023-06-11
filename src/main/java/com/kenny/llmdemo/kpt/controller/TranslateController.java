package com.kenny.llmdemo.kpt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenny.llmdemo.kpt.model.Translate;
import com.kenny.llmdemo.kpt.model.TranslateResponse;
import com.kenny.llmdemo.kpt.service.TranslateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/translate")
public class TranslateController {

    private static final Logger log = LoggerFactory.getLogger(TranslateController.class);
    private TranslateService translateService;


    @org.springframework.beans.factory.annotation.Autowired
    public TranslateController(TranslateService translateService) {
        this.translateService = translateService;
    }

    @PostMapping("/")
    public ResponseEntity<TranslateResponse> translate(@RequestBody Translate body) {
        return new ResponseEntity<TranslateResponse>(translateService.translate(body), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/")
    public ResponseEntity<String> getLastTranslate() {
        return new ResponseEntity<String>("Not Implemented", HttpStatusCode.valueOf(409));
    }

}
