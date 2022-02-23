package com.toy.trelloapi.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.context.annotation.Bean;

public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                    .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                    .setFieldMatchingEnabled(true);
        return modelMapper;
    }
}
