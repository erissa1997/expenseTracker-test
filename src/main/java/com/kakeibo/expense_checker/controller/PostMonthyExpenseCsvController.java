package com.kakeibo.expense_checker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kakeibo.expense_checker.auth.CheckToken;
import com.kakeibo.expense_checker.request.PostMonthyExpenseCsvRequest;
import com.kakeibo.expense_checker.response.AppResponse;
import com.kakeibo.expense_checker.response.MetaData;
import com.kakeibo.expense_checker.service.PostMonthlyExpenseCsvService;

@RestController
@CheckToken
@RequestMapping("/api/expenses")
public class PostMonthyExpenseCsvController {
    
    @Autowired
    private final PostMonthlyExpenseCsvService service;

    public PostMonthyExpenseCsvController(PostMonthlyExpenseCsvService service) {
        this.service = service;
    }

    /**
     * 
     * @param PostMonthyExpenseCsvRequest
     * @return AppResponse
     * @throw Exception
     */
    @PostMapping("/upload")
    public AppResponse<Object> invoke(PostMonthyExpenseCsvRequest request)  throws Exception {
        service.invoke(request);
        var metadata = new MetaData();
        return new AppResponse<Object>(metadata, null);
    }

}
