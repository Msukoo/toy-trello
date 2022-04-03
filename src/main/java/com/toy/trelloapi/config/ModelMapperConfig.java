package com.toy.trelloapi.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){ //entity객체를 dto객체로 변환시켜줄때 간편하게 아까처럼 한줄로 끝나니까 그런용도로 쓰는거같아요 그래서
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                    .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                    .setFieldMatchingEnabled(true);
        return modelMapper;
    }
}
