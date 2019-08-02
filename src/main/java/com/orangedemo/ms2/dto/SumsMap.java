package com.orangedemo.ms2.dto;

import com.orangedemo.ms2.model.TransactionType;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class SumsMap {
    private Map<TransactionType, BigDecimal> map = new HashMap<>();

    public SumsMap withIbanToIbanSum(BigDecimal ibanToIbanSum) {
        map.put(TransactionType.IBAN_TO_IBAN, ibanToIbanSum);
        return this;
    }

    public SumsMap withIbanToWalletSum(BigDecimal ibanToWallet) {
        map.put(TransactionType.IBAN_TO_WALLET, ibanToWallet);
        return this;
    }

    public SumsMap withWalletToIbanSum(BigDecimal walletToIban) {
        map.put(TransactionType.WALLET_TO_IBAN, walletToIban);
        return this;
    }

    public SumsMap withWalletToWalletSum(BigDecimal walletToWallet) {
        map.put(TransactionType.WALLET_TO_WALLET, walletToWallet);
        return this;
    }
}
