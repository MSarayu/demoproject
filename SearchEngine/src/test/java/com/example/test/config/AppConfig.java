package com.example.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.service.ElementSearchServiceImpl;
import com.example.service.IElementSearchService;

@Configuration
public class AppConfig {
    @Bean
    public IElementSearchService getSampleService() {
        return new ElementSearchServiceImpl();
    }
}