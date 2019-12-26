package com.booking.pwnsome_booking.service;

import com.booking.pwnsome_booking.dto.*;
import com.booking.pwnsome_booking.exception.*;
import com.booking.pwnsome_booking.model.*;
import org.springframework.stereotype.*;

import java.util.*;


public interface CustomerService{
    public Customer createCustomer (CustomerDTO customerDTO) throws UsernameExistsException;

    public Customer checkCustomer (CustomerDTO customerDTO) throws UsernameExistsException;
}
