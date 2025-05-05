package com.example.bookloan.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    //Constructeurs
    public User(){}

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Loan> loans = new ArrayList<>();

    //getters & setters
    public Long getId() {return id;}
    public String getName(){ return name;}
    public void setName(String name){this.name = name;}
    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}
    public List<Loan> getLoans() { return loans; }
    public void setLoans(List<Loan> loans) { this.loans = loans; }

}
