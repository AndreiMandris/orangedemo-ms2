package com.orangedemo.ms2.dto;

import java.math.BigDecimal;
import java.util.Objects;

public final class ReportLine {

    private String iban;
    private int noOfTransactions;
    private String cnp;
    private BigDecimal ibanToIbanSum;
    private BigDecimal ibanToWalletSum;
    private BigDecimal walletToIbanSum;
    private BigDecimal walletToWalletSum;

    private ReportLine(){
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

        public ReportBuilder withIbanToIbanSum(BigDecimal ibanToIbanSum) {
            report.ibanToIbanSum = ibanToIbanSum;
            return this;
        }

        public ReportBuilder withIbanToWalletSum(BigDecimal ibanToWalletSum) {
            report.ibanToWalletSum = ibanToWalletSum;
            return this;
        }

        public ReportBuilder withWalletToIbanSum(BigDecimal walletToIbanSum) {
            report.walletToIbanSum = walletToIbanSum;
            return this;
        }

        public ReportBuilder withWalletToWalletSum(BigDecimal walletToWalletSum) {
            report.walletToWalletSum = walletToWalletSum;
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

    public BigDecimal getIbanToIbanSum() {
        return ibanToIbanSum;
    }

    public BigDecimal getIbanToWalletSum() {
        return ibanToWalletSum;
    }

    public BigDecimal getWalletToIbanSum() {
        return walletToIbanSum;
    }

    public BigDecimal getWalletToWalletSum() {
        return walletToWalletSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReportLine that = (ReportLine) o;
        return noOfTransactions == that.noOfTransactions &&
                Objects.equals(iban, that.iban) &&
                Objects.equals(cnp, that.cnp) &&
                Objects.equals(ibanToIbanSum, that.ibanToIbanSum) &&
                Objects.equals(ibanToWalletSum, that.ibanToWalletSum) &&
                Objects.equals(walletToIbanSum, that.walletToIbanSum) &&
                Objects.equals(walletToWalletSum, that.walletToWalletSum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, noOfTransactions, cnp, ibanToIbanSum, ibanToWalletSum, walletToIbanSum, walletToWalletSum);
    }

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            ReportLine lineDto = new ReportLine();
            lineDto.cnp = this.cnp;
            lineDto.iban = this.iban;
            lineDto.ibanToIbanSum = this.ibanToIbanSum;
            lineDto.ibanToWalletSum = this.ibanToWalletSum;
            lineDto.walletToIbanSum = this.walletToIbanSum;
            lineDto.walletToWalletSum = this.walletToWalletSum;
            lineDto.noOfTransactions = this.noOfTransactions;
            return lineDto;
        }
    }
}
