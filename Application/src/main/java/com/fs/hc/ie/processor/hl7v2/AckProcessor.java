package com.fs.hc.ie.processor.hl7v2;

import ca.uhn.hl7v2.AcknowledgmentCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import org.apache.camel.CamelExecutionException;
import org.apache.camel.Exchange;
import org.hl7.fhir.exceptions.FHIRException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AckProcessor {
    public Message sendAck(Message message, Exchange exchange) throws IOException, HL7Exception {
        Message ack = message.generateACK();
        //exchange.getIn().setBody(ack);
        return ack;
    }

    public Message sendErrorAck(Message message, Exchange exchange) throws IOException, HL7Exception{
        HL7Exception hl7Exception = (HL7Exception) exchange.getProperty(Exchange.EXCEPTION_CAUGHT, CamelExecutionException.class).getCause();

        Message ack = message.generateACK(AcknowledgmentCode.AE, hl7Exception);
        return ack;
    }

    public Message sendRejectAck(Message message, Exchange exchange) throws IOException, HL7Exception{
        Message ack = message.generateACK(AcknowledgmentCode.AR, new HL7Exception("Reject message"));
        return ack;
    }
}
