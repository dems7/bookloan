package com.example.bookloan.controller;

import com.example.bookloan.model.Book;
import com.example.bookloan.service.BookService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    
    public BookController(BookService bookService){
        this.bookService= bookService;
    }

    @PostMapping
    public Book creatBook(Book book){
        return bookService.createBook(book);
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        Optional<Book> optionalBook = bookService.getBookById(id);
        if (optionalBook.isPresent()) {
            return ResponseEntity.ok(optionalBook.get());
        } else {
            return ResponseEntity.status(404).body("Livre inexistant");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id){
        boolean deleted = bookService.deleteBook(id);
        if (deleted) {
            return ResponseEntity.ok("livre supprimé");
        } else {
            return ResponseEntity.status(404).body("Le livre n'existe pas!");
        }
    }
    
}
