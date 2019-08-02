package com.orangedemo.ms2.service;

import com.orangedemo.ms2.dao.TransactionDao;
import com.orangedemo.ms2.dto.FullReport;
import com.orangedemo.ms2.dto.ReportLine;
import com.orangedemo.ms2.dto.TransactionDto;
import com.orangedemo.ms2.model.Transaction;
import com.orangedemo.ms2.model.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
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

        Map<TransactionType, BigDecimal> sums = new HashMap<>();
        sums.put(TransactionType.IBAN_TO_IBAN, new BigDecimal(0));
        sums.put(TransactionType.IBAN_TO_WALLET, new BigDecimal(0));
        sums.put(TransactionType.WALLET_TO_IBAN, new BigDecimal(0));
        sums.put(TransactionType.WALLET_TO_WALLET, new BigDecimal(0));

        transactionDtos.forEach(transactionDto ->
                sums.computeIfPresent(TransactionDto.resolveTransactionType(transactionDto.getType()),
                (k, v) -> v.add(transactionDto.getSum())));

        return new ReportLine.ReportBuilder()
                .withCnp(cnp)
                .withIban(iban)
                .withNoOfTransactions(noOfTransactions)
                .withSums(sums)
                .build();
    }
}
