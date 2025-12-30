package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class Configurations {
    @Bean
    public BufferedReader br() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    @Bean
    public Map<Integer, String> hs() {
        return new HashMap<>();
    }
}
