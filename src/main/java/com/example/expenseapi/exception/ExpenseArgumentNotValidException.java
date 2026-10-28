package com.example.expenseapi.exception;

public class ExpenseArgumentNotValidException extends RuntimeException {
        public ExpenseArgumentNotValidException(String message) {
            super(message);
        }
    }

