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
import org.springframework.web.servlet.mvc.support.*;

import javax.servlet.http.*;
import javax.validation.*;

@Controller
public class RegisterController {


    @Autowired
    private CustomerService customerService;


    @GetMapping("/registerPage")
    public String registerPage(Model model) {
        if(!model.asMap().containsKey("customerDTO")){
            model.addAttribute("customerDTO", new CustomerDTO());
        }
        return "register";
    }


    @RequestMapping(value = "/registerPage", method = RequestMethod.POST)
    public String registerPage(@ModelAttribute("customerDTO") @Valid CustomerDTO customerDTO, BindingResult result, WebRequest request, Model model, HttpSession session, RedirectAttributes redirectAttributes) {

        CustomerDTO newCustomer = new CustomerDTO();
        if(!result.hasErrors()){
            newCustomer = createAccount(customerDTO, result);
        }
        if(newCustomer == null){
            result.rejectValue("username", "username.exists", "There already exists a customer with the username "+customerDTO.getUsername());
        }
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("customerDTO", customerDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.customerDTO", result);
            return "redirect:/registerPage";
        }
        else{
            session.setAttribute("customerDTO", newCustomer);
            return "redirect:/customerPage";
        }
    }

    private CustomerDTO createAccount(CustomerDTO customerDTO, BindingResult result) {
        CustomerDTO registered = null;
        try{
            registered = customerService.createCustomer(customerDTO);
            return registered;
        }
        catch(UsernameExistsException e){
            return null;
        }
    }
}
