package ru.otr.integration.springboot.routes;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

/**
 * Created by tartanovmike on 03.12.16.
 */
@Component
public class TestRouteBuilder extends SpringRouteBuilder{


        @Override
        public void configure() throws Exception {

            // Read concurrently and transactionally from queue testQueue

            from("activemq:queue:testQueue").routeId("TestRoute1")
                    // Use JMS Transaction Manager as Platform manager
                    .transacted()
                    .setHeader("Name", simple("Vasia"))
                    .to("bean:TestBean");


            /*How to use xslt
            .to("xslt:xslt/extract_attachments.xsl")
            */

            /*How to use cxf bean
            .to("cxf:bean:smevMessageExchangeService")
            */

            /*How to use templates
            .to("freemarker:templates/GetRequestRequest.ftl")
            */




        }
}
