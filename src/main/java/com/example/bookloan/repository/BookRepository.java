package com.example.bookloan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookloan.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    Book findByTitle(String title);
}
