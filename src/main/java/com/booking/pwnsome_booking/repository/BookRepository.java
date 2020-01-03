package com.booking.pwnsome_booking.repository;

import com.booking.pwnsome_booking.model.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findBookByOwner(Customer owner);

    List<Book> findBooksByTaken(Boolean taken);

    Book findBookByTitle(String title);
}
