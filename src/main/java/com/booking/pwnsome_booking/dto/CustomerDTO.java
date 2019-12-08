package com.booking.pwnsome_booking.dto;

public class CustomerDTO {

    private Long id;
    private String username;
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
}
