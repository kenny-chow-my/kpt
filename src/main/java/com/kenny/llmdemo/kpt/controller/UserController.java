package com.kenny.llmdemo.kpt.controller;

import com.kenny.llmdemo.kpt.model.UserDetails;
import com.kenny.llmdemo.kpt.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    private UserService userService;


    public UserController(UserService service){
        this.userService = service;
    }

    @GetMapping("/principal")
    public OidcUser getOidcUser(@AuthenticationPrincipal OidcUser principal){
        return principal;
    }



    @GetMapping("/verify")
    public DefaultOidcUser getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.debug("Authentication from GET: {}", authentication);
        DefaultOidcUser oidcUser = (DefaultOidcUser) authentication.getPrincipal();
        return oidcUser;
    }

    @GetMapping("/claims")
    public Map<String,Object> getClaims(){
        return userService.getUserClaims();
    }
}
