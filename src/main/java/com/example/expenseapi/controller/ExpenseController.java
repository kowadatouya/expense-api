package com.example.expenseapi.controller;

import com.example.expenseapi.dto.Expense;
import com.example.expenseapi.service.ExpenseService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseservice) {
        this.expenseService = expenseservice;
    }
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses() {
        List<Expense> expenses = expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Expense> saveExpense(@RequestBody Expense expense,
                                         UriComponentsBuilder uriBuilder) {
        Expense createdExpense = expenseService.saveExpense(expense);

        URI location = uriBuilder.path("/api/expenses/{transactionid}")
                .buildAndExpand(createdExpense.getTransactionId()).toUri();

        return ResponseEntity.created(location).body(createdExpense);
    }

    @GetMapping("/{transactionid}")
    public ResponseEntity<Expense> getOneExpense(@PathVariable long transactionid){
        Expense expense = expenseService.getOneExpense(transactionid);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @DeleteMapping("/{transactionid}")
    public ResponseEntity<Void> delete(@PathVariable long transactionid) {
        expenseService.deleteExpense(transactionid);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{transactionid}")
    public ResponseEntity<Expense> update(@PathVariable long transactionid,
                                          @RequestBody Expense expense){
        expenseService.update(expense, transactionid);
        return ResponseEntity.ok(expense);
    }
}
