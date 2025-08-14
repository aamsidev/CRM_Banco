package com.proyecto.banco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
     WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // permite todos los endpoints
                        .allowedOrigins("http://localhost:4200") // origen Angular
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // métodos permitidos
                        .allowedHeaders("*")
                        .allowCredentials(true); // si usas cookies o sesiones
            }
        };
    }
}
