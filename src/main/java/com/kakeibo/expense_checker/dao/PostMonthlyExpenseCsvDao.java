package com.kakeibo.expense_checker.dao;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import lombok.extern.slf4j.Slf4j;

import com.kakeibo.expense_checker.model.Expense;
import com.kakeibo.expense_checker.repository.ExpenseRepository;

import jakarta.transaction.Transactional;

@Slf4j
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
    @Transactional
    public void insert(Set<Expense> list) {
        try {
            repository.saveAll(list);
        } catch (Exception e) {
            log.warn("Failure on batch insert: {}", e.getMessage());
        }
    }
    
}
