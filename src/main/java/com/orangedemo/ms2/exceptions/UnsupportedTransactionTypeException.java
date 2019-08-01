package com.orangedemo.ms2.exceptions;

public class UnsupportedTransactionTypeException extends RuntimeException {
    public UnsupportedTransactionTypeException() {
    }

    public UnsupportedTransactionTypeException(String message) {
        super(message);
    }
}
