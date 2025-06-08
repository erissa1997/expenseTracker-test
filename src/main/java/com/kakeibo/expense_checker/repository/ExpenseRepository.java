package com.kakeibo.expense_checker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kakeibo.expense_checker.enums.ExpenseCategory;
import com.kakeibo.expense_checker.model.Expense;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByDateBetween(LocalDate start, LocalDate end);
    List<Expense> findByCategoriesContaining(ExpenseCategory category);
}
