package com.booking.pwnsome_booking.util;

import com.booking.pwnsome_booking.dto.*;
import com.booking.pwnsome_booking.model.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

public class BookConverter {

    @Autowired
    private static ModelMapper modelMapper;

    public static BookDTO fromEntityToDTO(Book book){
        BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
        return bookDTO;
    }


    public static Book fromDTOToEntity(BookDTO bookDTO){
        Book book = modelMapper.map(bookDTO, Book.class);
        return book;
    }

    public static List<BookDTO> fromEntitiesToDTOs(List<Book> books){
        List<BookDTO> bookDTOs = new ArrayList<BookDTO>();
        for(Book book : books){
            bookDTOs.add(fromEntityToDTO(book));
        }
        return bookDTOs;
    }

    public static List<Book> fromDTOsToEntities(List<BookDTO> bookDTOs){
        List<Book> books = new ArrayList<Book>();
        for(BookDTO bookDTO : bookDTOs){
            books.add(fromDTOToEntity(bookDTO));
        }
        return books;
    }

}

