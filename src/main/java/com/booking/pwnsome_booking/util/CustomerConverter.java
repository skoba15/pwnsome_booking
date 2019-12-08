package com.booking.pwnsome_booking.util;

import com.booking.pwnsome_booking.dto.*;
import com.booking.pwnsome_booking.model.*;
import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

public class CustomerConverter {

    @Autowired
    private static ModelMapper modelMapper;

    public static CustomerDTO fromEntityToDTO(Customer customer){
        CustomerDTO customerDTO = modelMapper.map(customer, CustomerDTO.class);
        return customerDTO;
    }

    public static Customer fromDTOToEntity(CustomerDTO customerDTO){
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        return customer;
    }

    public static List<CustomerDTO> fromEntitiesToDTOs(List<Customer> customers){
        List<CustomerDTO> customerDTOs = new ArrayList<CustomerDTO>();
        for(Customer customer : customers){
            customerDTOs.add(fromEntityToDTO(customer));
        }
        return customerDTOs;
    }

    public static List<Customer> fromDTOsToEntities(List<CustomerDTO> customerDTOs){
        List<Customer> customers = new ArrayList<Customer>();
        for(CustomerDTO customerDTO : customerDTOs){
            customers.add(fromDTOToEntity(customerDTO));
        }
        return customers;
    }

}
