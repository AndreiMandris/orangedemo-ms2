package com.orangedemo.ms2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orangedemo.ms2.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ValidatedTransactionService {

    @Autowired
    private TransactionService transactionService;

    @JmsListener(destination = "standalone.queue")
    public void createValidatedTransaction(String transactionJson) throws IOException {
        TransactionDto transactionDto = new ObjectMapper()
                .readerFor(TransactionDto.class)
                .readValue(transactionJson);
        transactionService.saveTransaction(transactionDto);
    }
}
