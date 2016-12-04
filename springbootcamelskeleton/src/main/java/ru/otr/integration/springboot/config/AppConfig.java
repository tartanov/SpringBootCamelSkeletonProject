package ru.otr.integration.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by tartanovmike on 03.12.16.
 */
@Configuration
public class AppConfig {
    @Bean
    public CamelContextConfiguration contextConfiguration() {
        return new CamelContextConfiguration() {
            @Override
            public void beforeApplicationStart(CamelContext context) {
                context.setUseMDCLogging(true);
                context.setTracing(true);
                context.setStreamCaching(true);
                //context.setUnitOfWorkFactory(new CustomMDCUnitOfWorkFactory());
            }

            @Override
            public void afterApplicationStart(CamelContext camelContext) {
            }
        };
    }
}
