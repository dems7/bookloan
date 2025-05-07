package com.example.bookloan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookloan.exception.MaxLoansReachedException;
import com.example.bookloan.model.Book;
import com.example.bookloan.model.Loan;
import com.example.bookloan.model.User;
import com.example.bookloan.repository.BookRepository;
import com.example.bookloan.repository.UserRepository;
import com.example.bookloan.service.LoanService;

import ch.qos.logback.core.joran.conditional.IfAction;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/loans")
public class LoanController {
    private final LoanService loanService;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    
    public LoanController(LoanService loanService, UserRepository userRepository, BookRepository bookRepository){
        this.loanService = loanService;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    //Creer un emprunt
    @PostMapping
    public ResponseEntity<?> createLoan(@RequestParam Long userId, @RequestParam Long bookId){
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Book> bookOpt = bookRepository.findById(bookId);

        if (userOpt.isEmpty() || bookOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Utilisateur ou livre introuvable");
        }

        try {
            Loan loan = loanService.createLoan(userOpt.get(), bookOpt.get());
            return ResponseEntity.ok(loan);
        } catch (MaxLoansReachedException e) {
            return ResponseEntity.status(403).body(e.getMessage());
        }
    }

     //Récupérer tous les prêts
    @GetMapping
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }

}
