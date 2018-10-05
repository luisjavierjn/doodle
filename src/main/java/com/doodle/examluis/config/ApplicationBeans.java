package com.doodle.examluis.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeans {

    public @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
