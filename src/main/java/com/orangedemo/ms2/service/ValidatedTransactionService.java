package com.orangedemo.ms2.service;

import java.io.IOException;

public interface ValidatedTransactionService {
    void createValidatedTransaction(String transactionJson) throws IOException;
}
