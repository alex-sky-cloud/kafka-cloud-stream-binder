package com.stream.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Slf4j
@Configuration
public class ConsumerConfiguration {

    @Value("${spring.cloud.stream.function.definition}")
    private String definition;

    @Bean
    public Consumer<Long> consumer(){
        return i -> log.info("Definition : " + this.definition + " --- Consumer Received : " + i);
    }
}
