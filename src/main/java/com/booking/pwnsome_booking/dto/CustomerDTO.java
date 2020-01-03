package com.booking.pwnsome_booking.dto;

import com.booking.pwnsome_booking.controller.*;

import javax.validation.constraints.*;
import java.io.*;


public class CustomerDTO implements Serializable {




    private Long id;



    @NotNull
    @NotEmpty
    private String username;

    @NotNull
    @NotEmpty
    @ValidPassword
    @Size(min = 8)
    private String password;


    public CustomerDTO(String username, String password){
        this.password = password;
        this.username = username;
    }

    public CustomerDTO(){

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
