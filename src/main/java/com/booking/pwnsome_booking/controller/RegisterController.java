package com.booking.pwnsome_booking.controller;

import com.booking.pwnsome_booking.dto.*;
import com.booking.pwnsome_booking.exception.*;
import com.booking.pwnsome_booking.model.*;
import com.booking.pwnsome_booking.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.repository.config.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.*;
import org.springframework.web.servlet.*;

import javax.validation.*;

@Controller
public class RegisterController {


    @Autowired
    private CustomerService customerService;


    @GetMapping("/registerPage")
    public String registerPage(Model model) {
        model.addAttribute("customerDTO", new CustomerDTO());
        return "register";
    }


    @RequestMapping(value = "/registerCustomer", method = RequestMethod.POST)
    public ModelAndView homePage(@ModelAttribute("customerDTO") @Valid CustomerDTO customerDTO, BindingResult result, WebRequest request, Model model) {

        Customer customer = new Customer();
        if(!result.hasErrors()){
            customer = createAccount(customerDTO, result);
        }
        if(customer == null){
            result.rejectValue("username", "username.exists", "There already exists a customer with the username "+customerDTO.getUsername());
        }
        if(result.hasErrors()){
            return new ModelAndView("register", "customerDTO", customerDTO);
        }
        else{
            return new ModelAndView("CustomerPage", "customerDTO", customerDTO);
        }
    }

    private Customer createAccount(CustomerDTO customerDTO, BindingResult result) {
        Customer registered = null;
        try{
            registered = customerService.createCustomer(customerDTO);
            return registered;
        }
        catch(UsernameExistsException e){
            return null;
        }
    }
}
