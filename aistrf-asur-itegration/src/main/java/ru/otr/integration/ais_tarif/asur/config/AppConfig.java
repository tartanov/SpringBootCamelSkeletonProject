package ru.otr.integration.ais_tarif.asur.config;

import org.apache.camel.CamelContext;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public CamelContextConfiguration contextConfiguration() {
		return new CamelContextConfiguration() {
			@Override
			public void beforeApplicationStart(CamelContext context) {
				context.setUseMDCLogging(true);
				context.setTracing(false);
				context.setStreamCaching(true);
				// context.setUnitOfWorkFactory(new
				// CustomMDCUnitOfWorkFactory());
			}

			@Override
			public void afterApplicationStart(CamelContext camelContext) {
			}
		};
	}
}
