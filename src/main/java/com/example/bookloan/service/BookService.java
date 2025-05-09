package com.example.bookloan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.bookloan.model.Book;
import com.example.bookloan.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    //Creer livre
    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    //Afficher la liste des livres
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    //afficher un livre s'il existe
    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    //Supprimer un livre
    public boolean deleteBook(Long id){
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
