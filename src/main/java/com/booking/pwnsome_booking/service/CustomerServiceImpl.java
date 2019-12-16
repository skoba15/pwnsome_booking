package com.booking.pwnsome_booking.service;

import com.booking.pwnsome_booking.dto.*;
import com.booking.pwnsome_booking.exception.*;
import com.booking.pwnsome_booking.model.*;
import com.booking.pwnsome_booking.repository.*;
import com.booking.pwnsome_booking.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.parameters.*;
import org.springframework.stereotype.*;


@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(CustomerDTO customerDTO) throws UsernameExistsException {

        if(usernameExists(customerDTO.getUsername())){
            throw new UsernameExistsException("There already exists an account with the name " + customerDTO.getUsername());
        }
        return customerRepository.save(CustomerConverter.fromDTOToEntity(customerDTO));
    }


    private boolean usernameExists(String username){
        Customer customer = (Customer) customerRepository.findByUsername(username);
        if(customer != null){
            return true;
        }
        return false;
    }
}
