package com.kenny.llmdemo.kpt.config;

import com.kenny.llmdemo.kpt.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.oidc.authentication.OidcIdTokenDecoderFactory;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtDecoderFactory;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

@Slf4j
public class GoogleIDSecurityFilter extends OncePerRequestFilter {

    private static final String INVALID_ID_TOKEN_ERROR_CODE = "invalid_id_token";
    private UserService userService;

    private JwtDecoderFactory<ClientRegistration> jwtDecoderFactory = new OidcIdTokenDecoderFactory();

    private ClientRegistrationRepository clientRegistrationRepository;


    public GoogleIDSecurityFilter(ClientRegistrationRepository clientRegistrationRepository, UserService userService)
    {
        this.clientRegistrationRepository = clientRegistrationRepository;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authString = request.getHeader("Authorization");

        if(authString == null){
            log.debug("Missing Authorization header. Not performing any token processing.");
            filterChain.doFilter(request, response);
            return;
        }
        log.debug("AuthString: " + authString);
        String idTokenString = authString.substring("Bearer ".length());
        log.debug("OIDC SSO Filter processing request");
        if (idTokenString == null){
            log.debug("No idToken found. Continue chain");
            filterChain.doFilter(request, response);
            return;
        }

        ClientRegistration clientRegistration = this.clientRegistrationRepository.findByRegistrationId("google");

        JwtDecoder jwtDecoder = this.jwtDecoderFactory.createDecoder(clientRegistration);
        Jwt jwt;
        try {
            jwt = jwtDecoder.decode(idTokenString);
        } catch (JwtException ex) {
            OAuth2Error invalidIdTokenError = new OAuth2Error(INVALID_ID_TOKEN_ERROR_CODE, ex.getMessage(), null);
            throw new OAuth2AuthenticationException(invalidIdTokenError, invalidIdTokenError.toString(), ex);
        }

        OidcIdToken idToken = new OidcIdToken(jwt.getTokenValue(), jwt.getIssuedAt(), jwt.getExpiresAt(), jwt.getClaims());

        log.debug("Creating userinfo");
        OidcUserInfo userInfo = new OidcUserInfo(jwt.getClaims());

        Set<GrantedAuthority> authorities = new LinkedHashSet<>();
        authorities.add(new OidcUserAuthority(idToken, userInfo));

        String usernameAttribute = clientRegistration.getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        OidcUser oidcUser = new DefaultOidcUser(authorities, idToken, userInfo, usernameAttribute);

        OidcLoginAuthenticationToken authResult = new OidcLoginAuthenticationToken(oidcUser);

        log.debug("Setting Authentication");
        SecurityContextHolder.getContext().setAuthentication(authResult);
        onSuccessfulAuthentication(request, response, authResult);
        filterChain.doFilter(request, response);
    }

    protected void onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException {
        log.debug("Check if user exists");


        log.debug("Claims {}", this.userService.getUserClaims());
    }

}