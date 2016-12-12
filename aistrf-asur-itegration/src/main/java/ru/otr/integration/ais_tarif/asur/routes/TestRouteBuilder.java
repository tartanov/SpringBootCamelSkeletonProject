package ru.otr.integration.ais_tarif.asur.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class TestRouteBuilder extends SpringRouteBuilder {

	@Override
	public void configure() throws Exception {
		from("direct:start").routeId("testRoute1").transacted()
				.log(LoggingLevel.INFO, "ru.otr.integration.ais_tarif.asur", "Шаг 1").setHeader("Name", simple("Vasia"))
				.filter().xpath("$foo = 'bar'").log(LoggingLevel.INFO, "ru.otr.integration.ais_tarif.asur", "Шаг 2")
				.to("mock:result");

		from("direct:start2").routeId("testRoute2").to("seda:next").transform(constant("OK"));

		from("seda:next").routeId("testRoute3").to("mock:result");

		from("file:inbox").to("file:outbox");

		from("file:src/test/resources/xml/asurJuridicalResponse.xml").routeId("asurResponseRoute").to("mock:result");
	}
}
