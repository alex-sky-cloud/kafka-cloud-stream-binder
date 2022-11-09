package com.streams.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Function;
import java.util.logging.Level;

@Configuration
@Slf4j
public class ProcessorConfiguration {

    @Value("${spring.cloud.stream.function.definition}")
    private String definition;

    /**
     * Flux<Long> - тип данных которые читаются из Topic
     * Flux<Long> - тип данных, после обработки, которые будут
     * публиковаться в другой topic;
     * Данные потребляются из Topic - numbers, над ними происходит
     * обработка, затем данные поставляются в Topic - squares
     */
    @Bean
    public Function<Flux<Long>, Flux<Long>> processor(){

        return longFlux -> longFlux
                .map(index -> index * index)
                .log("Definition : " + this.definition, Level.INFO);
    }
}
