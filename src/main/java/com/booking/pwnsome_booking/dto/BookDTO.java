package com.booking.pwnsome_booking.dto;

import java.io.*;

public class BookDTO implements Serializable {

    private Long Id;
    private String title;
    private Boolean taken;

    private CustomerDTO owner;

    public CustomerDTO getUser() {
        return owner;
    }

    public void setUser(CustomerDTO owner) {
        this.owner = owner;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Boolean getTaken() {
        return taken;
    }

    public void setTaken(Boolean taken) {
        this.taken = taken;
    }

    public Long getId() {
        return Id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public BookDTO(String title) {
        this.title = title;
    }

    public BookDTO() {

    }
}
