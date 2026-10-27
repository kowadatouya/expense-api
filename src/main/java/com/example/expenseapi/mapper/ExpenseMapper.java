package com.example.expenseapi.mapper;

import com.example.expenseapi.dto.Expense;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ExpenseMapper {
    @Select("SELECT TransactionId, Amount, CategoryType, Description, created_At FROM expenses ORDER BY created_At DESC")
    List<Expense> getExpenses();

    @Insert("INSERT INTO expenses (Amount, CategoryType, Description) VALUES (#{amount}, #{categoryType}, #{description})")
    @Options(useGeneratedKeys = true, keyProperty = "TransactionId,createdAt", keyColumn = "transactionid,created_at")
    int insert(Expense expense);

    @Select("SELECT  TransactionId, Amount, CategoryType, Description, created_At FROM expenses WHERE transactionid = #{transactionid}")
    Expense getOneExpense(long transactionid);

    @Delete("DELETE FROM expenses WHERE TransactionId = #{TransactionId}")
    int deleteExpense(long TransactionId);

    @Update("UPDATE expenses SET Amount = #{Amount}, CategoryType = #{CategoryType}, Description = #{Description} WHERE TransactionId = #{TransactionId}")
    int updateExpense(Expense expense);
}
