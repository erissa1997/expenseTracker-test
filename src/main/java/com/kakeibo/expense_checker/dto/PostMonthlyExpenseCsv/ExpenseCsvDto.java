package com.kakeibo.expense_checker.dto.PostMonthlyExpenseCsv;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kakeibo.expense_checker.enums.PaymentType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ExpenseCsvDto(
    @NotBlank 
    @JsonProperty("利用日/キャンセル日")
    String  
    transactionDate,
    
    @JsonProperty("利用店名・商品名")  
    @NotBlank String 
    shop,
    
    @JsonProperty("利用金額")  
    @NotNull BigDecimal 
    amount,
    
    @JsonProperty("決済方法") 
    PaymentType 
    paymentType,

    @NotBlank 
    @JsonProperty("当月お支払日")
    String  
    paymentDate
) {}
