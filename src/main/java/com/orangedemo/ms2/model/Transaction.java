package com.orangedemo.ms2.model;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Column;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private String iban;

    private String cnp;

    private String name;

    @Column(name = "description")
    private String desc;

    private BigDecimal sum;

    public Transaction() {
    }

    public Transaction(BigInteger id, TransactionType type, String iban, String cnp, String name, String desc, BigDecimal sum) {
        this.id = id;
        this.type = type;
        this.iban = iban;
        this.cnp = cnp;
        this.name = name;
        this.desc = desc;
        this.sum = sum;
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
}
