package com.example.bookloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookloan.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    long countByUserId(Long userId);
}
