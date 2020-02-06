package com.booking.pwnsome_booking.controller;

import com.booking.pwnsome_booking.dto.*;
import com.booking.pwnsome_booking.exception.*;
import com.booking.pwnsome_booking.model.*;
import com.booking.pwnsome_booking.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
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
    public String homePage(@RequestParam(name = "error", required = false) boolean error, Model model) {
        model.addAttribute("appName", appName);
        if(!model.asMap().containsKey("customerDTO")) {
            model.addAttribute("customerDTO", new CustomerDTO());
        }
        if(error)model.addAttribute("errorMessage", "Either Username or Password is Incorrect");
        return "login";
    }



    @RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
    public String loginError(Model model) {
        model.addAttribute("customerDTO", new CustomerDTO());
        model.addAttribute("errorMessage", "Either username or Password is incorrect");
        return "login";
    }



    @RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
    public String loginSuccess(HttpSession session) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        session.setAttribute("customerDTO", customerService.getCustomer(authentication.getName()));
        return "redirect:/customerPage";
    }


    @RequestMapping(value = "/perform_logout", method = RequestMethod.GET)
    public void logout(HttpSession session) {
        session.removeAttribute("customerDTO");
    }




}