package com.orangedemo.ms2.controller;

import com.orangedemo.ms2.dto.TransactionDto;
import com.orangedemo.ms2.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public void saveTransaction(@RequestBody TransactionDto transactionDto) {
        transactionService.createTransaction(transactionDto);
    }
}
