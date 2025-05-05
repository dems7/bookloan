package com.example.bookloan.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;

    //relation Book vers emprunt
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Loan> loans = new ArrayList<>();

    public Book() {}

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Long getId() { return id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public List<Loan> getLoans() { return loans; }

    public void setLoans(List<Loan> loans) { this.loans = loans; }
}
