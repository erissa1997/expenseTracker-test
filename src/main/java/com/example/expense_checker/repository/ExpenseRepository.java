package com.example.expense_checker.repository;

import com.example.expense_checker.enums.ExpenseCategory;
import com.example.expense_checker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByDateBetween(LocalDate start, LocalDate end);
    List<Expense> findByCategoriesContaining(ExpenseCategory category);
}
