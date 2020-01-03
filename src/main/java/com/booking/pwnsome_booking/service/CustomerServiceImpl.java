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
    public CustomerDTO createCustomer(CustomerDTO customerDTO) throws UsernameExistsException {
        CustomerDTO newCustomer = usernameExists(customerDTO.getUsername());
        if(newCustomer != null){
            throw new UsernameExistsException("There already exists an account with the name " + customerDTO.getUsername());
        }
        return CustomerConverter.fromEntityToDTO(customerRepository.save(CustomerConverter.fromDTOToEntity(customerDTO)));
    }

    @Override
    public CustomerDTO checkCustomer(CustomerDTO customerDTO) throws UsernameExistsException {
        CustomerDTO customer = usernameExists(customerDTO.getUsername());
        if(customer != null && customerDTO.getPassword().equals(customer.getPassword())){
            return customer;
        }
        else{
            return null;
        }
    }

    @Override
    public CustomerDTO getCustomer(String username) {
        return CustomerConverter.fromEntityToDTO(customerRepository.findByUsername(username));
    }


    private CustomerDTO usernameExists(String username){
        if(customerRepository.findByUsername(username) != null) {
            CustomerDTO customerDTO = CustomerConverter.fromEntityToDTO(customerRepository.findByUsername(username));
            return customerDTO;
        }
        return null;
    }
}
