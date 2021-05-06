package com.fs.hc.ie.routes;

import static org.apache.camel.component.hl7.HL7.messageConformsTo;
import static org.apache.camel.component.hl7.HL7.ack;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class HL7v2RouteTest extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("netty:tcp://localhost:8889?sync=true&encoders=#hl7Encoder&decoders=#hl7Decoder").
                routeId("hl7v2test").
                log("${body}").
                unmarshal().hl7().
                log("${body}").transform(ack());
    }
}
