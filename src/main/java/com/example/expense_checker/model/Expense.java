package com.example.expense_checker.model;

import com.example.expense_checker.enums.ExpenseCategory;
import com.example.expense_checker.enums.PaymentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate date;

    @NotNull
    private String merchant;

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "expense_categories", joinColumns = @JoinColumn(name = "expense_id"))
    @Column(name = "category")
    private Set<@NotNull ExpenseCategory> categories;

    private String eventName;
}
