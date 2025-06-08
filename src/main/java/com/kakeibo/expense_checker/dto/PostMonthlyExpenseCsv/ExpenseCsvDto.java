package com.kakeibo.expense_checker.dto.PostMonthlyExpenseCsv;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kakeibo.expense_checker.enums.PaymentType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ExpenseCsvDto(
    @NotBlank 
    @JsonProperty("利用日/キャンセル日")
    @JsonDeserialize(using = LocalDateYMDDeserializer.class)
    LocalDate
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
    @JsonDeserialize(using = LocalDateYMDDeserializer.class)
    LocalDate  
    paymentDate
) {
    public class LocalDateYMDDeserializer extends JsonDeserializer<LocalDate> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy/M/d");

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String rawDate = p.getText().trim();
        return LocalDate.parse(rawDate, FORMATTER);
    }
}


}
