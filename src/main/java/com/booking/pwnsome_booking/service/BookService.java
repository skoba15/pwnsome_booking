package com.booking.pwnsome_booking.service;

import com.booking.pwnsome_booking.dto.*;
import com.booking.pwnsome_booking.model.*;

import java.util.*;

public interface BookService {

    public void createBook(BookDTO bookDTO);

    public List<BookDTO> getBooks();

    public List<BookDTO> getBooksByCustomer(CustomerDTO customerDTO);

}
