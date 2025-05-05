package com.example.bookloan.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.bookloan.model.Book;
import com.example.bookloan.model.Loan;
import com.example.bookloan.model.User;
import com.example.bookloan.repository.LoanRepository;

@Service
public class LoanService {
    private final LoanRepository loanRepo;

    public LoanService (LoanRepository loanRepo){
        this.loanRepo = loanRepo;
    }

    public Boolean canUserBorrow (Long userId){
        Long count = loanRepo.countByUserId(userId);
        return count<3;
    }

    public Loan createLoan(User user, Book book){
        if (!canUserBorrow(user.getId())) {
            throw new IllegalStateException("L'utilisateur a déjà emprunté 3 livres.");
        }

        Loan loan = new Loan(user, book, LocalDate.now());
        return loanRepo.save(loan);
    }
}