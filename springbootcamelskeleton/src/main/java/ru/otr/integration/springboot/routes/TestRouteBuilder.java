package ru.otr.integration.springboot.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.stereotype.Component;

import java.util.HashMap;

import static org.apache.camel.component.xquery.XQueryBuilder.xquery;

/**
 * Created by tartanovmike on 03.12.16.
 */
@Component
public class TestRouteBuilder extends SpringRouteBuilder{


        @Override
        public void configure() throws Exception {

            // Read concurrently and transactionally from queue testQueue

            from("activemq:queue:testQueueRequest").routeId("TestRoute1")
                    // Use JMS Transaction Manager as Platform manager
                    .transacted()
                    .log(LoggingLevel.INFO, "ru.otr.integration.springboot", "ping")
                    .setHeader("Name", simple("Vasia"))
                    .to("bean:testBean")
                    .log(LoggingLevel.INFO, "ru.otr.integration.springboot", "pong")
                    .to("activemq:queue:testQueueResponse");

            from("activemq:queue:testSplitQueueRequest").split(body().tokenize(",")).streaming().to("activemq:queue:testSplitQueueResponse");


            from("timer://foo?period=60000")
                    .setBody(constant("select * from PERSON"))
                    .to("jdbc:myDataSource?outputType=StreamList")
                    .split(body())
                    .streaming()
                    .to("activemq:queue:dbResponse");

            from("activemq:queue:dbResponse")
                    .convertBodyTo(HashMap.class)
                    .to("bean:testCB")
                    ;


            from("activemq:queue:bookStoreRequest")
                    .setHeader("myParamValue", simple("40"))
                    .to("activemq:queue:bookStoreResponse")
                    .to("xquery:xquery/myquery.xq");
                    //.transform(xquery("<books>{for $x in /bookstore/book where $x/price>30 order by $x/title return $x/title}</books>"))
                    //.to("activemq:queue:bookStoreResponse");


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
