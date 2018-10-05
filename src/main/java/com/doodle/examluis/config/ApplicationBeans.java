package com.doodle.examluis.config;

import com.mongodb.MongoClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class ApplicationBeans {

    @Value("${spring.data.mongodb.host}")
    private String host;

    @Value("${spring.data.mongodb.database}")
    private String database;

    public @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate =
                new MongoTemplate(new MongoClient(host), database);
        return mongoTemplate;
    }
}
