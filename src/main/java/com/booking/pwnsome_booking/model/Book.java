package com.booking.pwnsome_booking.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String title;
    private Boolean taken;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer owner;

    public Customer getUser() {
        return owner;
    }

    public void setUser(Customer owner) {
        this.owner = owner;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Boolean getTaken() {
        return taken;
    }

    public Book(String title) {
        this.title = title;
    }

    public Book() {

    }

}
