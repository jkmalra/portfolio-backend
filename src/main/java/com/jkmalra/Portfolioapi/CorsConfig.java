package com.jkmalra.Portfolioapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(@NonNull CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins(
                                "http://127.0.0.1:5500",               // for local development
                                "https://jkmalra.github.io"           // for GitHub Pages (must be HTTPS)
                        )
                        .allowedMethods("GET", "POST")
                        .allowedHeaders("*");
            }
        };
    }
}
