package com.kakeibo.expense_checker.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kakeibo.expense_checker.model.Expense;
import com.kakeibo.expense_checker.repository.ExpenseRepository;

@Repository
public class PostMonthlyExpenseCsvDao {

    @Autowired
    private ExpenseRepository repository;

    /**
     * 
     * @param DtoList
     * 
     * @return void
     */
    public void insert(List<Expense> list) {
        repository.saveAll(list);
    }
    
}
