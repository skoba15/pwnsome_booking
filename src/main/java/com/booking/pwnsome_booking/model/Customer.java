package com.booking.pwnsome_booking.model;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Customer")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;


    public Customer(String username, String password){
        this.password = password;
        this.username = username;
    }

    public Customer(){

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

}
