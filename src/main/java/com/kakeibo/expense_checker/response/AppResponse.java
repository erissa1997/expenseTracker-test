package com.kakeibo.expense_checker.response;

public record AppResponse<T extends Object>(
    MetaData meta,
    T result
) {}
