package com.booking.pwnsome_booking.dto;

public class BookDTO {

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

    public BookDTO(String title) {
        this.title = title;
    }

    public BookDTO() {

    }
}
