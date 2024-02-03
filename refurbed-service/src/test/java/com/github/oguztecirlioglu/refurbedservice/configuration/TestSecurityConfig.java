package com.github.oguztecirlioglu.refurbedservice.configuration;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/* NOT USED ANYMORE, WAS USED BEFORE TO BYPASS SPRING SECURITY.
   NOW USING ".with(user("user").roles("USER"))" */

@TestConfiguration
public class TestSecurityConfig {

    @Bean
    public SecurityFilterChain testSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().permitAll()
                );
        return http.build();
    }
}

