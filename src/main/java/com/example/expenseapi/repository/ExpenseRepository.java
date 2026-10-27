package com.example.expenseapi.repository;

import com.example.expenseapi.dto.Expense;
import com.example.expenseapi.mapper.ExpenseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExpenseRepository {
    private final ExpenseMapper expenseMapper;
    public ExpenseRepository(ExpenseMapper expenseMapper) {
        this.expenseMapper = expenseMapper;
    }

    public List<Expense> findAll() {
        return expenseMapper.getExpenses();
    }

    public int insertExpense(Expense expense){
        return expenseMapper.insert(expense);
    }

    public Expense getOneExpense(long transactionid){
        return expenseMapper.getOneExpense(transactionid);
    }

    public boolean delete(long TransactionId){
        return expenseMapper.deleteExpense(TransactionId) == 1;
    }

    public Expense update(Expense expense){
        return expense;
    }
}
