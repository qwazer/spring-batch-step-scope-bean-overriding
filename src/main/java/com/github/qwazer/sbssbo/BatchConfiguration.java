package com.github.qwazer.sbssbo;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/job.xml")
public class BatchConfiguration {

    @Bean
    public ItemWriter dummyWriter(){
        return items -> { };
    }
}
