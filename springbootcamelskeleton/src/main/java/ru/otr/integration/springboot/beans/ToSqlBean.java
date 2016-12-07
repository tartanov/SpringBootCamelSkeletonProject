package ru.otr.integration.springboot.beans;

import org.apache.camel.Headers;
import org.apache.camel.language.XPath;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by tartanov.mikhail on 05.12.2016.
 */

@Component(value = "toSqlBean")
public class ToSqlBean {
    public String toSql(@XPath("order/@name") String name,
                        @XPath("order/@amount") int amount,
                        @XPath("order/@customer") String customer,
                        @Headers Map<String, Object> outHeaders) {
        outHeaders.put("partName", name);
        outHeaders.put("quantity", amount);
        outHeaders.put("customer", customer);
        return "insert into incoming_orders (part_name, quantity, customer) values (:?partName, :?quantity, :?customer)";
    }

}
