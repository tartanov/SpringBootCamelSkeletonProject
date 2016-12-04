package ru.otr.integration.springboot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by tartanovmike on 03.12.16.
 */
@Component
@ConfigurationProperties
public class AppProperties {
    private String foo;

    public String getFoo() {
        return foo;
    }
    public void setFoo(String foo) {
        this.foo = foo;
    }
}
