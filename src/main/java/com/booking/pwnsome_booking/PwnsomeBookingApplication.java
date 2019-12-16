package com.booking.pwnsome_booking;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.*;
import org.thymeleaf.spring5.*;
import org.thymeleaf.spring5.view.*;
import org.thymeleaf.templateresolver.*;

@SpringBootApplication
public class PwnsomeBookingApplication {

    public static void main(String[] args) {

        SpringApplication.run(PwnsomeBookingApplication.class, args);
    }

}
