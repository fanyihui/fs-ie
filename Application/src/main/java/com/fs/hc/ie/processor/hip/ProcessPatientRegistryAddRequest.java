package com.fs.hc.ie.processor.hip;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.language.xpath.XPathBuilder;
import org.apache.commons.collections.map.HashedMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.util.Map;

public class ProcessPatientRegistryAddRequest {
    public void process(Exchange exchange) throws XPathExpressionException{
        String pat_id = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/id/@extension").
                evaluate(exchange, String.class);
        String ssn = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/id/@extension").
                evaluate(exchange, String.class);
        String status = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/statusCode/@code").evaluate(exchange, String.class);
        String name = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/name/text()").evaluate(exchange, String.class);
        String birth = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/birthTime/@value").evaluate(exchange, String.class);
        String telecom = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/telecom/@value").evaluate(exchange, String.class);
        String gender = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/administrativeGenderCode/@displayName").evaluate(exchange, String.class);
        String gender_code = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/administrativeGenderCode/@code").evaluate(exchange, String.class);
        String address = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/addr/streetAddressLine/text()").evaluate(exchange, String.class);
        String maritalStatusCode = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/maritalStatusCode/@code").evaluate(exchange, String.class);
        String maritalStatusName = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/maritalStatusCode/@displayName").evaluate(exchange, String.class);
        String ethnicGroupCode = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/ethnicGroupCode/@code").evaluate(exchange, String.class);
        String ethnicGroupName = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/ethnicGroupCode/@displayName").evaluate(exchange, String.class);
        String occupationCode = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/asEmployee/occupationCode/@code").evaluate(exchange, String.class);
        String occupationName = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/asEmployee/occupationCode/@displayName").evaluate(exchange, String.class);
        String employer_name = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/asEmployee/employerOrganization/name/text()").evaluate(exchange, String.class);
        String employer_telecom = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/asEmployee/employerOrganization/contactParty/telecom/@value").evaluate(exchange, String.class);
        String contact_code = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/personalRelationship/code/text()").evaluate(exchange, String.class);
        String contact_telecom = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/personalRelationship/telecom/@value").evaluate(exchange, String.class);
        String contact_name = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/personalRelationship/relationshipHolder1/name/text()").evaluate(exchange, String.class);
        String org_id = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/providerOrganization/id/@extension").evaluate(exchange, String.class);
        String org_name = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/providerOrganization/name/text()").evaluate(exchange, String.class);
        String insurance_code = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/coveredPartyOf/coverageRecord/beneficiary/beneficiary/code/@code").evaluate(exchange, String.class);
        String insurance_name = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/coveredPartyOf/coverageRecord/beneficiary/beneficiary/code/@displayName").evaluate(exchange, String.class);
        String register_id = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/author/assignedEntity/id/@extension").evaluate(exchange, String.class);
        String register_name = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/author/assignedEntity/assignedPerson/name/text()").evaluate(exchange, String.class);
        String registry_time = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/effectiveTime/@value").evaluate(exchange, String.class);

        String health_card_no = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/asOtherIDs/id[@root='2.16.156.10011.1.19']/@extension").evaluate(exchange, String.class);
        String health_card_authority = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/asOtherIDs[//id/@root='2.16.156.10011.1.19']/scopingOrganization/id/@extension").evaluate(exchange, String.class);

        String mrn = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/asOtherIDs/id[@root='2.16.156.10011.1.2']/@extension").evaluate(exchange, String.class);
        String mrn_authority = XPathBuilder.xpath("/PRPA_IN201311UV02/controlActProcess/subject/registrationRequest/subject1/patient/patientPerson/asOtherIDs[//id/@root='2.16.156.10011.1.2']/scopingOrganization/id/@extension").evaluate(exchange, String.class);

        Map<String, String> map = new HashedMap();
        map.put("pat_id", pat_id);
        map.put("ssn", ssn);
        map.put("status", status);
        map.put("name", name);
        map.put("birth", birth);
        map.put("telecom", telecom);
        map.put("gender", gender_code);
        map.put("gender_name", gender);
        map.put("address", address);
        map.put("marital", maritalStatusCode);
        map.put("marital_name", maritalStatusName);
        map.put("ethnic", ethnicGroupCode);
        map.put("ethnic_name", ethnicGroupName);
        map.put("occupation_code", occupationCode);
        map.put("occupation_name", occupationName);
        map.put("employer_name", employer_name);
        map.put("employer_telecom", employer_telecom);
        map.put("contact_code", contact_code);
        map.put("contact_name", contact_name);
        map.put("contact_telecom", contact_telecom);
        map.put("org_id", org_id);
        map.put("org_name", org_name);
        map.put("insurance_code", insurance_code);
        map.put("insurance_name", insurance_name);
        map.put("register_id", register_id);
        map.put("register_name", register_name);
        map.put("registry_time", registry_time);
        map.put("health_card_no", health_card_no);
        map.put("health_card_authority", health_card_authority);
        map.put("mrn", mrn);
        map.put("mrn_authority", mrn_authority);

        exchange.getIn().setHeader("TABLE_NAME", "pat_registry.pat_registry_add");
        exchange.getIn().setBody(map);
    }
}
