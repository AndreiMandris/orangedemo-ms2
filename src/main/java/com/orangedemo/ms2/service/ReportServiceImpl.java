package com.orangedemo.ms2.service;

import com.orangedemo.ms2.dao.TransactionDao;
import com.orangedemo.ms2.dto.FullReport;
import com.orangedemo.ms2.dto.ReportLine;
import com.orangedemo.ms2.dto.TransactionDto;
import com.orangedemo.ms2.exceptions.UnsupportedTransactionTypeException;
import com.orangedemo.ms2.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    @Autowired
    private TransactionDao transactionDao;

    @Override
    public FullReport getReportByCnp(String cnp) {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        for (Transaction transaction : transactionDao.getAllByCnp(cnp)) {
            transactionDtos.add(TransactionDto.toTransactionDto(transaction));
        }
        return new FullReport(generateReport(transactionDtos));
    }

    private List<ReportLine> generateReport(List<TransactionDto> transactionDtos) {
        Map<String, List<TransactionDto>> transactionsGroupedByIban = transactionDtos
                .stream().collect(Collectors.groupingBy(TransactionDto::getIban));

        List<ReportLine> reportLines = new ArrayList<>();
        transactionsGroupedByIban.forEach((k, v) -> reportLines.add(computeReport(v)));
        return reportLines;
    }

    private ReportLine computeReport(List<TransactionDto> transactionDtos) {
        String iban = transactionDtos.get(0).getIban();
        int noOfTransactions = transactionDtos.size();
        String cnp = transactionDtos.get(0).getCnp();
        BigDecimal ibanToIbanSum = new BigDecimal(0);
        BigDecimal ibanToWalletSum = new BigDecimal(0);
        BigDecimal walletToIbanSum = new BigDecimal(0);
        BigDecimal walletToWalletSum = new BigDecimal(0);

        for (TransactionDto transactionDto : transactionDtos) {
            switch (transactionDto.getType()) {
                case IBAN_TO_IBAN:
                    ibanToIbanSum = ibanToIbanSum.add(transactionDto.getSum());
                    break;
                case IBAN_TO_WALLET:
                    ibanToWalletSum = ibanToWalletSum.add(transactionDto.getSum());
                    break;
                case WALLET_TO_IBAN:
                    walletToIbanSum = walletToIbanSum.add(transactionDto.getSum());
                    break;
                case WALLET_TO_WALLET:
                    walletToWalletSum = walletToWalletSum.add(transactionDto.getSum());
                    break;
                default:
                    throw new UnsupportedTransactionTypeException("Transaction type not supported!");
            }
        }

        return new ReportLine.ReportBuilder()
                .withCnp(cnp)
                .withIban(iban)
                .withNoOfTransactions(noOfTransactions)
                .withIbanToIbanSum(ibanToIbanSum)
                .withIbanToWalletSum(ibanToWalletSum)
                .withWalletToIbanSum(walletToIbanSum)
                .withWalletToWalletSum(walletToWalletSum)
                .build();
    }
}
