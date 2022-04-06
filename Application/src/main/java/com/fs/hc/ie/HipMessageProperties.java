package com.fs.hc.ie;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "com.fs.hc.ie.hip")
@PropertySource(value = "hip.properties")

public class HipMessageProperties {
    String address = "http://localhost:9001/hipMessageServer";

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
