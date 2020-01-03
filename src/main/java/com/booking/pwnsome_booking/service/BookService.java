package com.booking.pwnsome_booking.service;

import com.booking.pwnsome_booking.dto.*;
import com.booking.pwnsome_booking.model.*;
import org.springframework.stereotype.*;

import java.util.*;


public interface BookService {

    public void createBook(BookDTO bookDTO);

    public List<BookDTO> getBooks();


    public BookDTO getBookByName(String bookName);

    public List<BookDTO> getBooksByCustomer(CustomerDTO customerDTO);


    public void updateBook(BookDTO bookDTO);

}
