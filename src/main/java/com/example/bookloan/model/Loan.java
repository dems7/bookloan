package com.example.bookloan.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private LocalDate loanDate;

    public Loan() {}

    public Loan(User user, Book book, LocalDate loanDate) {
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
    }

    public Long getId() { return id; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Book getBook() { return book; }

    public void setBook(Book book) { this.book = book; }

    public LocalDate getLoanDate() { return loanDate; }

    public void setLoanDate(LocalDate loanDate) { this.loanDate = loanDate; }
}
