package com.kenny.llmdemo.kpt.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        Set<String> googleScopes = new HashSet<>();
        googleScopes.add("https://www.googleapis.com/auth/userinfo.email");
        googleScopes.add("https://www.googleapis.com/auth/userinfo.profile");

        OidcUserService googleUserService = new OidcUserService();
        googleUserService.setAccessibleScopes(googleScopes);

        http.csrf().disable().cors().and()

                .authorizeRequests()
                .requestMatchers("/translate/**").permitAll()
                .requestMatchers("/language-pair/**").permitAll()
                .requestMatchers(HttpMethod.OPTIONS,  "/**").permitAll()
                .requestMatchers("/user/**").authenticated()
                .anyRequest().permitAll();

        http.oauth2Login(oauthLogin -> oauthLogin.userInfoEndpoint()
                        .oidcUserService(googleUserService));
        return http.build();

//        http.authorizeRequests(authorizeRequests -> authorizeRequests
//                        .antMatchers("/translate/**")
//
//                        .anyRequest()
//                        .authenticated())
//                .oauth2Login(oauthLogin -> oauthLogin.userInfoEndpoint()
//                        .oidcUserService(googleUserService));
//        return http.build();
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}