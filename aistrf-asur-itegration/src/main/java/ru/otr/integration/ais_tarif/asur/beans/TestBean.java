package ru.otr.integration.ais_tarif.asur.beans;

import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.otr.integration.ais_tarif.asur.config.AppProperties;

@Component(value = "testBean")
public class TestBean {
	@Autowired
	private AppProperties appProperties;

	// Camel Exchange will be autoinjected
	public void swapNamespaces(Exchange exchange, @Header("Name") String name) {
		exchange.getIn().setBody("Hello " + name + ". Message content is \"" + exchange.getIn().getBody() + "\"");

	}
}
