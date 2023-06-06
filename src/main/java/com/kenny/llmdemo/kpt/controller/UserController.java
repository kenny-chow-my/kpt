package com.kenny.llmdemo.kpt.controller;

import com.kenny.llmdemo.kpt.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;


    public UserController(UserService service){
        this.userService = service;
    }

    @GetMapping("/principal")
    public OidcUser getOidcUser(@AuthenticationPrincipal OidcUser principal){
        return principal;
    }

    @GetMapping("/claims")
    public Map<String,Object> getClaims(){
        return userService.getUserClaims();
    }
}
