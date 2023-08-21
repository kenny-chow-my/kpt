package com.kenny.llmdemo.kpt.service;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import com.kenny.llmdemo.kpt.model.UserDetails;
import com.kenny.llmdemo.kpt.repo.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDetailRepo userDetailRepo;

    public Map<String, Object> getUserClaims() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        if (authentication.getPrincipal() instanceof OidcUser) {
            OidcUser principal = ((OidcUser) authentication.getPrincipal());
            return principal.getClaims();
        }
        return Collections.emptyMap();
    }


    public UserDetails getUserByEmail(String email){
        Optional<UserDetails> userDetails = userDetailRepo.findByEmail(email);
        return userDetails.orElse(null);

    }

    public void saveUser(UserDetails userDetails){
        userDetailRepo.save(userDetails);
    }


}