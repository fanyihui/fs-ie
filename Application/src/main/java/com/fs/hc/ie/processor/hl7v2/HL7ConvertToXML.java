package com.fs.hc.ie.processor.hl7v2;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.CanonicalModelClassFactory;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.XMLParser;
import org.springframework.stereotype.Component;

@Component
public class HL7ConvertToXML {
    public String convertToXML(Message message) throws HL7Exception {
        String version = message.getVersion();
        XMLParser parser = new DefaultXMLParser(new CanonicalModelClassFactory(version));
        return parser.encode(message);
    }
}
