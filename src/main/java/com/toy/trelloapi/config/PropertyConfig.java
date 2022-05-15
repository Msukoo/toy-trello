package com.toy.trelloapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:properties/application-${spring.profiles.active}.yml", "classpath:properties/common.yml"}, factory = PropertySourceFactory.class, ignoreResourceNotFound = true)
public class PropertyConfig {
}
