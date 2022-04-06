package com.fs.hc.ie.processor.hip;

import com.fs.hc.ie.component.chis.exception.StandardNotSupportException;
import com.fs.hc.ie.component.chis.model.HIPAction;
import org.apache.camel.Exchange;
import org.apache.cxf.message.MessageContentsList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HipMessageServiceHandler{
    private static final Logger LOGGER = LoggerFactory
            .getLogger(HipMessageServiceHandler.class);

    public void process(Exchange exchange) throws StandardNotSupportException {
        MessageContentsList messageContentsList = exchange.getIn().getBody(MessageContentsList.class);
        String action = messageContentsList.get(0).toString();
        String message = messageContentsList.get(1).toString();

        try {
            HIPAction hipAction = HIPAction.valueOf(action);
        } catch (IllegalArgumentException illegalArgumentException){
            throw new StandardNotSupportException(action);
        }

        exchange.getIn().setHeader("ACTION", action);
        exchange.getIn().setBody(message);

        //TODO validate incoming message one by one and build a response message accordi

    }
}
