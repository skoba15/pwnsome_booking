package com.booking.pwnsome_booking.service;

import com.booking.pwnsome_booking.dto.*;
import com.booking.pwnsome_booking.model.*;
import com.booking.pwnsome_booking.repository.*;
import com.booking.pwnsome_booking.util.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void createBook(BookDTO bookDTO) {
        Book book = BookConverter.fromDTOToEntity(bookDTO);
        bookRepository.save(book);
    }

    @Override
    public List<BookDTO> getBooks() {
        ArrayList<BookDTO> books = (ArrayList<BookDTO>) BookConverter.fromEntitiesToDTOs((List<Book>) bookRepository.findAll());
        return books;
    }

    @Override
    public List<BookDTO> getBooksByCustomer(CustomerDTO customerDTO) {
        Customer customer = CustomerConverter.fromDTOToEntity(customerDTO);
        List<BookDTO> books = BookConverter.fromEntitiesToDTOs((ArrayList<Book>) bookRepository.findBookByOwner(customer));
        return books;
    }

}
