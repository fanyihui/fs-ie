package com.fs.hc.ie;

import com.fs.hc.ie.processor.hip.HipMessageServiceHandler;
import com.fs.hc.ie.processor.hip.HipSqlBuilder;
import com.fs.hc.ie.processor.hip.ProcessPatientRegistryAddRequest;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.camel.component.hl7.HL7MLLPCodec;
import org.apache.camel.component.hl7.HL7MLLPNettyDecoderFactory;
import org.apache.camel.component.hl7.HL7MLLPNettyEncoderFactory;
import org.hl7.v3.HL7MessageServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FsieAppConfig {
    @Autowired
    HipMessageProperties hipMessageProperties;

    @Bean
    HL7MLLPNettyDecoderFactory hl7Decoder(){
        HL7MLLPNettyDecoderFactory hl7MLLPNettyDecoderFactory = new HL7MLLPNettyDecoderFactory();
        hl7MLLPNettyDecoderFactory.setConvertLFtoCR(true);
        return hl7MLLPNettyDecoderFactory;
    }

    @Bean
    HL7MLLPNettyEncoderFactory hl7Encoder(){
        HL7MLLPNettyEncoderFactory hl7MLLPNettyEncoderFactory = new HL7MLLPNettyEncoderFactory();
        hl7MLLPNettyEncoderFactory.setConvertLFtoCR(true);
        return hl7MLLPNettyEncoderFactory;
    }

    @Bean
    HL7MLLPCodec hl7MLLPCodec(){
        HL7MLLPCodec hl7Codec = new HL7MLLPCodec();
        hl7Codec.setConvertLFtoCR(true);
        return hl7Codec;
    }

    @Bean
    CxfEndpoint hipEndpoint(){
        CxfEndpoint cxfEndpoint = new CxfEndpoint();
        cxfEndpoint.setServiceClass(HL7MessageServerService.class);
        cxfEndpoint.setAddress(hipMessageProperties.address);
        cxfEndpoint.setWsdlURL("wsdl/HIPMessageServer.wsdl");

        return cxfEndpoint;
    }

    @Bean
    HipMessageServiceHandler hipMessageServiceHandler(){
        return new HipMessageServiceHandler();
    }

    @Bean
    ProcessPatientRegistryAddRequest processPatientRegistryAddRequest(){
        return new ProcessPatientRegistryAddRequest();
    }
    @Bean
    HipSqlBuilder hipSqlBuilder(){
        return new HipSqlBuilder();
    }

}
