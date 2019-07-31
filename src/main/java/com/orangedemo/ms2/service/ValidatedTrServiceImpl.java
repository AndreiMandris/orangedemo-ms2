package com.orangedemo.ms2.service;

import com.google.gson.Gson;
import com.orangedemo.ms2.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ValidatedTrServiceImpl implements ValidatedTrService{

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private Gson gson;

    @Override
    @JmsListener(destination = "standalone.queue")
    public void createValidatedTransaction(String transactionJson) {
        TransactionDto transactionDto = gson.fromJson(transactionJson, TransactionDto.class);
        System.out.println("Received [" + transactionDto + "]");
        transactionService.createTransaction(transactionDto);
    }
}
