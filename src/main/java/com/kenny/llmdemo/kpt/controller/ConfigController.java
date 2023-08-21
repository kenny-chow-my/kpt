package com.kenny.llmdemo.kpt.controller;

import com.kenny.llmdemo.kpt.model.LanguagePair;
import com.kenny.llmdemo.kpt.model.Persona;
import com.kenny.llmdemo.kpt.service.ConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/config")
public class ConfigController {

    private static final Logger log = LoggerFactory.getLogger(ConfigController.class);

    private ConfigService configService;


    @Autowired
    public ConfigController(ConfigService configService) {
        this.configService = configService;
    }
    @GetMapping("/languages")
    public ResponseEntity<List<LanguagePair>> listLanguagePair(String language) {
        return new ResponseEntity<>(configService.getAllLanguagePairs(), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/personas")
    public ResponseEntity<List<Persona>> listLanguagePair() {
        return new ResponseEntity<>(configService.getAllPersonas(), HttpStatusCode.valueOf(200));
    }


}
