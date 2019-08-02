package com.orangedemo.ms2.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.orangedemo.ms2.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UncheckedIOException;

@Service
public class ValidatedTransactionServiceImpl implements ValidatedTransactionService {

    @Autowired
    private TransactionService transactionService;

    @Override
    @JmsListener(destination = "standalone.queue")
    public void createValidatedTransaction(String transactionJson) {
        try {
            TransactionDto transactionDto = new ObjectMapper()
                    .readerFor(TransactionDto.class)
                    .readValue(transactionJson);
            transactionService.saveTransaction(transactionDto);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
