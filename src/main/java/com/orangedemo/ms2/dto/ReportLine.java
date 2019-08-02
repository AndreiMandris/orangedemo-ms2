package com.orangedemo.ms2.dto;

import com.orangedemo.ms2.model.TransactionType;

import java.math.BigDecimal;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Collections;
import java.util.Objects;

public class ReportLine {

    private String iban;
    private int noOfTransactions;
    private String cnp;
    private final Map<TransactionType, BigDecimal> sums;

    private ReportLine() {
        sums = new LinkedHashMap<>();
        sums.put(TransactionType.IBAN_TO_IBAN, new BigDecimal(0));
        sums.put(TransactionType.IBAN_TO_WALLET, new BigDecimal(0));
        sums.put(TransactionType.WALLET_TO_IBAN, new BigDecimal(0));
        sums.put(TransactionType.WALLET_TO_WALLET, new BigDecimal(0));
    }

    public ReportLine(Map<TransactionType, BigDecimal> sums) {
        this.sums = Collections.unmodifiableMap(sums);
    }

    public static class ReportBuilder {
        ReportLine report;

        public ReportBuilder() {
            this.report = new ReportLine();
        }

        public ReportBuilder withIban(String iban) {
            report.iban = iban;
            return this;
        }

        public ReportBuilder withNoOfTransactions(int noOfTransactions) {
            report.noOfTransactions = noOfTransactions;
            return this;
        }

        public ReportBuilder withCnp(String cnp) {
            report.cnp = cnp;
            return this;
        }

        public ReportBuilder withSums(Map<TransactionType, BigDecimal> sums){
            report.sums.putAll(sums);
            return this;
        }

        public ReportLine build() {
            return report;
        }
    }

    public String getIban() {
        return iban;
    }

    public int getNoOfTransactions() {
        return noOfTransactions;
    }

    public String getCnp() {
        return cnp;
    }

    public Map<TransactionType, BigDecimal> getSums() {
        return Collections.unmodifiableMap(sums);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportLine that = (ReportLine) o;
        return noOfTransactions == that.noOfTransactions &&
                Objects.equals(iban, that.iban) &&
                Objects.equals(cnp, that.cnp) &&
                Objects.equals(sums, that.sums);
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            ReportLine lineDto = new ReportLine(this.sums);
            lineDto.cnp = this.cnp;
            lineDto.iban = this.iban;
            lineDto.noOfTransactions = this.noOfTransactions;
            return lineDto;
        }
    }
}
