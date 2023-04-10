package com.fs.hc.ie;

import org.apache.camel.CamelContext;
import org.apache.camel.opentelemetry.starter.CamelOpenTelemetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages= {"com.fs.hc.ie"})
@CamelOpenTelemetry
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
