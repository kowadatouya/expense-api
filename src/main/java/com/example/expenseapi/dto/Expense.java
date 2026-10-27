package com.example.expenseapi.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Expense {
    private long TransactionId;
    private long Amount;
    private String CategoryType;
    private String Description;
    private LocalDateTime createdAt;
}
