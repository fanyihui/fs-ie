package com.fs.hc.ie;

import org.apache.camel.spi.annotations.Component;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Component("")
@PropertySource(value = "application.properties")

public class FsieApplicationProperties {
}
