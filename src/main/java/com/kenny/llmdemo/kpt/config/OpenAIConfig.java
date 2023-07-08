package com.kenny.llmdemo.kpt.config;

import com.kenny.llmdemo.kpt.interceptor.HttpRequestResponseInterceptor;
import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.Retryer;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Indexed;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConfigurationProperties
@Indexed
@Data
public class OpenAIConfig {

    @Value("${openai.http-client.read-timeout}")
    private int readTimeout;

    @Value("${openai.http-client.connect-timeout}")
    private int connectTimeout;

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.model}")
    private String model;


    @Bean
    public Request.Options options() {
        return new Request.Options(getConnectTimeout(), getReadTimeout());
    }

    @Bean
    public Logger.Level feignLogger() {
        return Logger.Level.FULL;
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default();
    }

    @Bean
    public RequestInterceptor apiKeyInterceptor() {
        return request -> request.header("Authorization", "Bearer " + apiKey);
    }
}