package com.kakeibo.expense_checker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kakeibo.expense_checker.dto.PostMonthlyExpenseCsv.ExpenseCsvDto;
import com.kakeibo.expense_checker.request.PostMonthyExpenseCsvRequest;

@Service
public class PostMonthlyExpenseCsvService {

    /**
     * 
     * @param req
     * 
     * @return PostMonthyExpenseCsvResult
     * @throw Exception
     */
    public void invoke(PostMonthyExpenseCsvRequest req) throws Exception
    {
        //decode

        //parse
        //validate Header
        //validate body(data)
        List<ExpenseCsvDto> insertList = List.of();
        try {
            
        } catch (Exception e) {
            // TODO: exception handling
        }
    }
}
