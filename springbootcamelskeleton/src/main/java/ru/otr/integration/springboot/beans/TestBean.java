package ru.otr.integration.springboot.beans;

import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.otr.integration.springboot.config.AppProperties;

/**
 * Created by tartanovmike on 03.12.16.
 */
@Component
public class TestBean {
    @Autowired
    private AppProperties appProperties;
    // Camel Exchange will be autoinjected
    public void swapNamespaces(Exchange exchange, @Header("Name") String name) {
        exchange.getIn().setBody("Hello" + name);

    }
}
