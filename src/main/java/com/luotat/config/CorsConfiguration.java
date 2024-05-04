package com.luotat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer
{
    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        registry.addMapping("/**")
                .allowedOrigins("*")
                //.allowedOrigins("http://localhost:8081")
                //.allowedOrigins("http://10.241.222.5:8081")
                //.allowedOrigins("http://10.240.194.103:8080")
                .allowedMethods("*")
                //.allowCredentials(true)
                .maxAge(3600);
    }
}
