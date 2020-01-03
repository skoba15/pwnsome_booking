package com.booking.pwnsome_booking.controller;


import com.booking.pwnsome_booking.dto.*;
import com.booking.pwnsome_booking.model.*;
import com.booking.pwnsome_booking.repository.*;
import com.booking.pwnsome_booking.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import javax.validation.*;
import java.util.*;

@Controller
public class LibraryController {


    @Autowired
    private BookService bookService;


    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;



    @RequestMapping(value = "/customerBooks/{username}", method = RequestMethod.GET)
    public String getAllBooks(@PathVariable(value = "username") String username, Model model) {
        CustomerDTO customerDTO = customerService.getCustomer(username);
        List<BookDTO> books = bookService.getBooksByCustomer(customerDTO);
        model.addAttribute("books", books);
        model.addAttribute("pageType", "myBooks");
        model.addAttribute("username", customerDTO.getUsername());
        return "booksPage";
    }



    @RequestMapping(value = "/allBooks", method = RequestMethod.GET)
    public String getAllBooks(Model model, HttpSession session) {
        List<BookDTO> books = bookService.getBooks();
        model.addAttribute("books", books);
        model.addAttribute("pageType", "allBooks");
        CustomerDTO customerDTO = (CustomerDTO) session.getAttribute("customerDTO");
        model.addAttribute("username", customerDTO.getUsername());
        return "booksPage";
    }

}
