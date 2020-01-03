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
import org.springframework.web.servlet.mvc.support.*;

import javax.servlet.http.*;
import javax.validation.*;
import java.util.*;

@Controller
public class LoginController {
    @Value("${spring.application.name}")
    String appName;


    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        if(!model.asMap().containsKey("customerDTO")){
            model.addAttribute("customerDTO", new CustomerDTO());
        }
        return "login";
    }


    @RequestMapping(value = "/loginCustomer", method = RequestMethod.POST)
    public String homePage(@ModelAttribute("customerDTO") @Valid CustomerDTO customerDTO, BindingResult result, WebRequest request, Model model, RedirectAttributes redirectAttributes,  HttpSession session) throws UsernameExistsException {

        CustomerDTO customer = null;
        if(!result.hasErrors()){
            customer = customerService.checkCustomer(customerDTO);
        }
        if(customer == null){
            result.rejectValue("username", "incorrectFields", "Either Username or Password is incorrect");
        }
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("customerDTO", customerDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.customerDTO", result);
            return "redirect:";
        }
        else{
            session.setAttribute("customerDTO", customer);
            return "redirect:/customerPage";
        }
    }

}