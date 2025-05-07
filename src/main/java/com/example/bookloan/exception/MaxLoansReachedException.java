package com.example.bookloan.exception;

public class MaxLoansReachedException extends RuntimeException{
    public MaxLoansReachedException(String message) {
        super(message);
    }
}
