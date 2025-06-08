package com.kakeibo.expense_checker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import com.kakeibo.expense_checker.enums.ExpenseCategory;
import com.kakeibo.expense_checker.enums.PaymentType;

@Data
@Entity
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private LocalDate transactionDate;

    @NotNull
    private String merchant;

    @NotNull
    @Positive
    private BigDecimal amount;

    @NotNull
    private LocalDate paymentDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "expense_categories", joinColumns = @JoinColumn(name = "expense_id"))
    @Column(name = "category")
    private Set<@NotNull ExpenseCategory> categories;
 
    protected Expense() {}

    public Expense(
        LocalDate transactionDate, 
        String merchant, 
        BigDecimal amount, 
        LocalDate paymentDate) {
        this.transactionDate = transactionDate;
        this.merchant = merchant;
        this.amount = amount;
        this.paymentDate = paymentDate;
        //TODO: this.categories = categories; TODO;Change category from Enum to Entity
    }
}
