package ru.otr.integration.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:/applicationContext.xml", "classpath:/applicationContextDB.xml"})
public class SpringbootcamelskeletonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootcamelskeletonApplication.class, args);
	}
}
