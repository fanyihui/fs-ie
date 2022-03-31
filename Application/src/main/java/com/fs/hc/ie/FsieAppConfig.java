package com.fs.hc.ie;

import com.fs.hc.ie.component.chis.processor.HipMessageServiceHandler;
import com.fs.hc.ie.component.chis.processor.ProcessPatientRegistryAddRequest;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.camel.component.cxf.DataFormat;
import org.apache.camel.component.hl7.HL7MLLPCodec;
import org.apache.camel.component.hl7.HL7MLLPNettyDecoderFactory;
import org.apache.camel.component.hl7.HL7MLLPNettyEncoderFactory;
import org.apache.cxf.binding.BindingConfiguration;
import org.hl7.v3.HIPMessageServerResponse;
import org.hl7.v3.HL7MessageServerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.naming.Binding;

@Configuration
public class FsieAppConfig {
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
        cxfEndpoint.setAddress("http://localhost:9001/hipMessageServer");
        cxfEndpoint.setWsdlURL("wsdl/HIPMessageServer.wsdl");
        //cxfEndpoint.setDataFormat(DataFormat.PAYLOAD);

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
}
