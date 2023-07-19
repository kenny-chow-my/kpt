package com.kenny.llmdemo.kpt.controller;

import com.kenny.llmdemo.kpt.model.LanguagePair;
import com.kenny.llmdemo.kpt.service.LanguagePairService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/language-pair")
public class LanguagePairController {

    private static final Logger log = LoggerFactory.getLogger(LanguagePairController.class);

    private LanguagePairService languagePairService;


    @Autowired
    public LanguagePairController( LanguagePairService languagePairService) {
        this.languagePairService = languagePairService;
    }
    @GetMapping("/")
    public ResponseEntity<List<LanguagePair>> listLanguagePair(String language) {
        return new ResponseEntity<>(languagePairService.getAllLanguagePairs(), HttpStatusCode.valueOf(200));
    }

}
