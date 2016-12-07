package ru.otr.integration.springboot.beans;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

/**
 * Created by tartanov.mikhail on 06.12.2016.
 */
@Component(value = "testCB")
public class TestBodyConvertationBean {
    public void test(Exchange exchange) {
        exchange.getIn().getBody();
    }
}
