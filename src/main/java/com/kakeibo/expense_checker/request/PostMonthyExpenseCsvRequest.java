package com.kakeibo.expense_checker.request;

import jakarta.validation.constraints.NotBlank;

public record PostMonthyExpenseCsvRequest(
    @NotBlank(message = "LACK_REQUIRED_VALUE")
    String csv
) {
}
