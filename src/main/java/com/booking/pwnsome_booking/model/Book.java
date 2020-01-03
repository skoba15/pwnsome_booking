package com.booking.pwnsome_booking.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
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

    public void setTaken(Boolean taken) {
        this.taken = taken;
    }

    public Long getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
