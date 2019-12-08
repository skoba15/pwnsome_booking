package com.booking.pwnsome_booking.config;

import org.modelmapper.*;
import org.springframework.context.annotation.*;

@Configuration
public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }
}
