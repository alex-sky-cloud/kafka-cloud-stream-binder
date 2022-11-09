package com.stream.producer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.function.Supplier;
import java.util.logging.Level;

@Configuration
@Slf4j
public class ProducerConfiguration {

    @Value("${spring.cloud.stream.function.definition}")
    private String definition;

    /**
     * генерируем каждую секунду по числу. Числа генерируются по порядку
     * и публикуются в указанную Topic. Конфигурация Topic определяется через
     * application.yml.
     * Выходной канал Producer должен совпадать с именем входного канала Processor
     */
    @Bean
    public Supplier<Flux<Long>> producer(){

        return () -> Flux.interval(Duration.ofSeconds(1))
                .log("Definition : " + this.definition, Level.INFO);
    }
}