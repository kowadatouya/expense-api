package com.example.expenseapi.service;

import com.example.expenseapi.dto.Expense;
import com.example.expenseapi.repository.ExpenseRepository;
import lombok.experimental.Delegate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class ExpenseService {
    private ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @GetMapping
    public List<Expense> getAllExpenses() {return expenseRepository.findAll();}

    public Expense saveExpense(Expense expense) {
        expenseRepository.insertExpense(expense);
        return expense;
    }

    public Expense getOneExpense(Long transactionid) {
        return expenseRepository.getOneExpense(transactionid);
    }

    public boolean deleteExpense(long transactionid) {
//        if (!expenseRepository.delete(transactionid)) {
//            throw new ExpenseNotFoundException(transactionid);
//        }
        return true;
    }

    public Expense update(Expense expense, long transactionid){
        Expense targetExpense = expenseRepository.getOneExpense(transactionid);
        if (targetExpense == null) {
//            throw new ExpenseNotFoundException(transactionid);
        }

        expense.setTransactionId(transactionid);
        expense.setCreatedAt(targetExpense.getCreatedAt());
        return expenseRepository.update(expense);
    }
}
