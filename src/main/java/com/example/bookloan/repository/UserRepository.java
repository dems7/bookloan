package com.example.bookloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookloan.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
    User findByEmail(String email);
}
