package com.booking.pwnsome_booking.controller;

import com.booking.pwnsome_booking.dto.*;
import com.booking.pwnsome_booking.exception.*;
import com.booking.pwnsome_booking.model.*;
import com.booking.pwnsome_booking.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.*;

import javax.validation.*;

@Controller
public class LoginController {
    @Value("${spring.application.name}")
    String appName;


    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("customerDTO", new CustomerDTO());
        return "login";
    }


    @RequestMapping(value = "/loginCustomer", method = RequestMethod.POST)
    public ModelAndView homePage(@ModelAttribute("customerDTO") @Valid CustomerDTO customerDTO, BindingResult result, WebRequest request, Model model) throws UsernameExistsException {

        Customer customer = null;
        if(!result.hasErrors()){
            customer = customerService.checkCustomer(customerDTO);
        }
        if(customer == null){
            result.rejectValue("username", "incorrectFields", "Either Username or Password is incorrect");
        }
        if(result.hasErrors()){
            return new ModelAndView("login", "customerDTO", customerDTO);
        }
        else{
            return new ModelAndView("CustomerPage", "customerDTO", customerDTO);
        }
    }

}