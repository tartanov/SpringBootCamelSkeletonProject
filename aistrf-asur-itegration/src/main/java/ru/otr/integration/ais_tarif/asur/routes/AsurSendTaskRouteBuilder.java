package ru.otr.integration.ais_tarif.asur.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AsurSendTaskRouteBuilder extends SpringRouteBuilder {

	@Autowired



	@Override
	public void configure() throws Exception {

		// Read concurrently and transactionally from queue testQueue
		from("activemq:queue:asurSendTaskRequest?")
				.routeId("asurSendTaskRoute")
				.transacted()
				.log(LoggingLevel.INFO, "ru.otr.integration.ais_tarif.asur", "ping").setHeader("Name", simple("Vasia"))
				.to("bean:testBean").log(LoggingLevel.INFO, "ru.otr.integration.ais_tarif.asur", "pong")
				.to("activemq:queue:asurSendTaskResponse");
	}
}
