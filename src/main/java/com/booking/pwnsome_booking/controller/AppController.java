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
import org.springframework.web.servlet.mvc.support.*;

import javax.servlet.http.*;
import javax.validation.*;

@Controller
public class AppController {

    @Autowired
    private BookService bookService;


    @RequestMapping(value = "/getBook/{bookName}", method = RequestMethod.POST)
    public String homePage(@PathVariable(value = "bookName") String bookName, Model model, HttpSession session) {
        BookDTO bookDTO = bookService.getBookByName(bookName);
        System.out.println("bookName" + bookDTO.getTitle());
        CustomerDTO customerDTO = (CustomerDTO) session.getAttribute("customerDTO");
        System.out.println("bookId" + customerDTO.getUsername());
        bookDTO.setUser(customerDTO);
        bookDTO.setTaken(true);
        bookService.updateBook(bookDTO);
        return "redirect:/allBooks";
    }

    @RequestMapping(value = "/removeBook/{bookName}", method = RequestMethod.POST)
    public String removeBook(@PathVariable(value = "bookName") String bookName, Model model, HttpSession session) {
        BookDTO bookDTO = bookService.getBookByName(bookName);
        CustomerDTO customerDTO = (CustomerDTO) session.getAttribute("customerDTO");
        bookDTO.setUser(null);
        bookDTO.setTaken(false);
        bookService.updateBook(bookDTO);
        return "redirect:/customerBooks/" + customerDTO.getUsername();
    }


    @RequestMapping(value = "/customerPage", method = RequestMethod.GET)
    public String homePage(Model model, HttpSession session) {
        model.addAttribute("customerDTO", session.getAttribute("customerDTO"));
        return "customerPage";
    }

}
