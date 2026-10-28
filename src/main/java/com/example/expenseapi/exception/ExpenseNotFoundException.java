package com.example.expenseapi.exception;

public class ExpenseNotFoundException extends RuntimeException {
    public ExpenseNotFoundException(long transactionid) {
        super("指定されたIDがが見つかりません: " + transactionid);
    }
}
