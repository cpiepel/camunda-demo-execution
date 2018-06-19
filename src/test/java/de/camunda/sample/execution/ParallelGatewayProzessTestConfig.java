package de.camunda.sample.execution;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class ParallelGatewayProzessTestConfig {


    @Bean
    public Service service() throws Exception {
        return new Service();
    }


}