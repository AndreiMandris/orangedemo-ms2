package com.orangedemo.ms2.service;

import com.orangedemo.ms2.dao.TransactionDao;
import com.orangedemo.ms2.dto.TransactionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionDao transactionDao;

    @Override
    public void saveTransaction(TransactionDto transactionDto) {
        transactionDao.save(transactionDto.toTransaction());
    }
}
