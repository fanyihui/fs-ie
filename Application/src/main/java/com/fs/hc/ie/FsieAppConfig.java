package com.fs.hc.ie;

import org.apache.camel.component.hl7.HL7MLLPCodec;
import org.apache.camel.component.hl7.HL7MLLPNettyDecoderFactory;
import org.apache.camel.component.hl7.HL7MLLPNettyEncoderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

}
