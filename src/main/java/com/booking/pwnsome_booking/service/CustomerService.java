package com.booking.pwnsome_booking.service;

import com.booking.pwnsome_booking.dto.*;
import com.booking.pwnsome_booking.exception.*;
import com.booking.pwnsome_booking.model.*;
import org.springframework.stereotype.*;

import java.util.*;


public interface CustomerService{
    public CustomerDTO createCustomer (CustomerDTO customerDTO) throws UsernameExistsException;

    public CustomerDTO checkCustomer (CustomerDTO customerDTO) throws UsernameExistsException;

    public CustomerDTO getCustomer(String username);
}
