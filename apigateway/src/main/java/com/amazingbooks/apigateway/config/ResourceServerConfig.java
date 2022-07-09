package com.amazingbooks.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.web.server.SecurityWebFilterChain;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Configuration
@EnableWebFluxSecurity
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity){


       httpSecurity.authorizeExchange()
                .anyExchange().authenticated().and().oauth2ResourceServer().jwt();
        return httpSecurity.build();
    }

    @Bean
    public ReactiveJwtDecoder jwtDecoder(){
        byte[] keyBytes = "123456789012345678901234567890AB".getBytes();
        SecretKeySpec secretKeySpec = new  SecretKeySpec(keyBytes,"AES");
        return NimbusReactiveJwtDecoder.withSecretKey(secretKeySpec).build();
    }
}
