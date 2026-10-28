package com.example.expenseapi.exception.handler;

import com.example.expenseapi.exception.ExpenseArgumentNotValidException;
import com.example.expenseapi.exception.ExpenseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExpenseNotFoundException.class)
    public ResponseEntity<String> handleExpenseNotFoundException(ExpenseNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ExpenseArgumentNotValidException.class)
    public ResponseEntity<String> handleExpenseArgumentNotValidException(ExpenseArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
