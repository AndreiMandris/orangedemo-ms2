package com.orangedemo.ms2.dto;

import com.orangedemo.ms2.model.Transaction;
import com.orangedemo.ms2.model.TransactionType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

public class TransactionDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigInteger id;
    private TransactionType type;
    private String iban;
    private String cnp;
    private String name;
    private String desc;
    private BigDecimal sum;

    public TransactionDto() {
    }

    public TransactionDto(BigInteger id, TransactionType type, String iban, String cnp, String name, String desc, BigDecimal sum) {
        this.id = id;
        this.type = type;
        this.iban = iban;
        this.cnp = cnp;
        this.name = name;
        this.desc = desc;
        this.sum = sum;
    }

    public Transaction toTransaction() {
        Transaction transaction = new Transaction();
        transaction.setType(this.getType());
        transaction.setIban(this.getIban());
        transaction.setCnp(this.getCnp());
        transaction.setName(this.getName());
        transaction.setDesc(this.getDesc());
        transaction.setSum(this.getSum());
        return transaction;
    }

    public static TransactionDto fromTransactionToDto(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setCnp(transaction.getCnp());
        transactionDto.setIban(transaction.getIban());
        transactionDto.setDesc(transaction.getDesc());
        transactionDto.setName(transaction.getName());
        transactionDto.setSum(transaction.getSum());
        transactionDto.setType(transaction.getType());
        return transactionDto;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id=" + id +
                ", type=" + type +
                ", iban='" + iban + '\'' +
                ", cnp='" + cnp + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", sum=" + sum +
                '}';
    }
}

