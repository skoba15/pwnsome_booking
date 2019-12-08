package com.booking.pwnsome_booking.repository;

import com.booking.pwnsome_booking.model.*;
import org.springframework.data.repository.*;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByUsername(String Username);

    Customer findById(long Id);

}
