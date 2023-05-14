package com.example.JakSim.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String connectTrainerPath = "/files/trainer/**";
        String resourceTrainerPath = "file:///C:/projects/JakSim/src/main/resources/static/files/trainer/";
        registry.addResourceHandler(connectTrainerPath).addResourceLocations(resourceTrainerPath);

        String connectReviewPath = "/files/review/**";
        String resourceReviewPath = "file:///Users/janghyolim/code/JakSim/src/main/resources/static/files/review/";
        registry.addResourceHandler(connectReviewPath).addResourceLocations(resourceReviewPath);
    }
}
