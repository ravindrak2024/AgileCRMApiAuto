package com.agilecrm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@ComponentScan(basePackages = { "com.agilecrm.*" })
@PropertySources({
        @PropertySource("classpath:${env}.properties"),
        @PropertySource("classpath:contacts.properties"),
        @PropertySource("classpath:company.properties")
})
public class EnvironmentConfig {
}
