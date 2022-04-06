package com.fs.hc.ie.processor.hip;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.language.xpath.XPathBuilder;
import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

public class ProcessPatientRegistryAddRequest {
    public void process(Exchange exchange){
        System.out.println(exchange.getIn().getBody(String.class));
        CamelContext context = exchange.getContext();
        String pat_id = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/id/@extension").
                evaluate(exchange, String.class);
        String ssn = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/id/@extension").
                evaluate(exchange, String.class);
        String status = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/statusCode/@code").evaluate(exchange, String.class);
        String name = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/name/text()").evaluate(exchange, String.class);
        String birth = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/birthTime/@value").evaluate(exchange, String.class);
        String telecom = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/telecom/@value").evaluate(exchange, String.class);
        String gender = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/administrativeGenderCode/@displayName").evaluate(exchange, String.class);
        String address = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/addr/streetAddressLine/text()").evaluate(exchange, String.class);
        String maritalStatusCode = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/maritalStatusCode/@code").evaluate(exchange, String.class);
        String ethnicGroupCode = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/ethnicGroupCode/@code").evaluate(exchange, String.class);

        Map<String, String> map = new HashedMap();
        map.put("pat_id", pat_id);
        map.put("ssn", ssn);
        map.put("status", status);
        map.put("name", name);
        map.put("birth", birth);
        map.put("telecom", telecom);
        map.put("gender", gender);
        map.put("address", address);
        map.put("marital", maritalStatusCode);
        map.put("ethnic", ethnicGroupCode);

        exchange.getIn().setHeader("TABLE_NAME", "pat_registry.pat_registry_add");
        exchange.getIn().setBody(map);
    }
}
