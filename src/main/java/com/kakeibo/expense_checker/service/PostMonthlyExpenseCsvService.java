package com.kakeibo.expense_checker.service;

import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.kakeibo.expense_checker.dao.PostMonthlyExpenseCsvDao;
import com.kakeibo.expense_checker.dto.PostMonthlyExpenseCsv.ExpenseCsvDto;
import com.kakeibo.expense_checker.model.Expense;
import com.kakeibo.expense_checker.request.PostMonthyExpenseCsvRequest;

@Service
public class PostMonthlyExpenseCsvService {

    @Autowired
    private PostMonthlyExpenseCsvDao dao;

    
    
    /**
     * 
     * @param req
     * 
     * @return PostMonthyExpenseCsvResult
     * @throw Exception
     */
    public void invoke(PostMonthyExpenseCsvRequest req) throws Exception
    {
        // decode
        byte[] decoded = Base64.getDecoder().decode(req.csv());
        String csv = new String(decoded, StandardCharsets.UTF_8);

        //parse
        var parsed = parse(csv);
        //validate Header
        //validate body(data)
        Set<Expense> records = parsed
            .stream()
            .map(v-> 
                 new Expense(
                    v.transactionDate(),
                    v.shop(),
                    v.amount(),
                    v.paymentDate()))
            .collect(Collectors.toSet());
        try {
            dao.insert(records);
        } catch (Exception e) {
            // TODO: exception handling
        }
    }


    public List<ExpenseCsvDto> parse(String csvContent) throws Exception {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = CsvSchema.emptySchema().withHeader();

        ObjectReader reader = mapper.readerFor(ExpenseCsvDto.class).with(schema);
        MappingIterator<ExpenseCsvDto> iterator = reader.readValues(new StringReader(csvContent));

        return iterator.readAll();
    }


}
