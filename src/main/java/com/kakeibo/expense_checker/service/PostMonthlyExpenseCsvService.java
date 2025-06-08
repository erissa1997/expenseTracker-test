package com.kakeibo.expense_checker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kakeibo.expense_checker.dao.PostMonthlyExpenseCsvDao;
import com.kakeibo.expense_checker.dto.PostMonthlyExpenseCsv.ExpenseCsvDto;
import com.kakeibo.expense_checker.request.PostMonthyExpenseCsvRequest;

public class PostMonthlyExpenseCsvService {


    @Autowired
    private final PostMonthlyExpenseCsvDao dao;

    public PostMonthlyExpenseCsvService(PostMonthlyExpenseCsvDao dao) {
        this.dao = dao;
    }

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
            dao.insert(insertList);
        } catch (Exception e) {
            // TODO: exception handling
        }
    }
}
