package com.orangedemo.ms2.dao;

import com.orangedemo.ms2.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface TransactionDao extends JpaRepository<Transaction, BigInteger> {
    List<Transaction> getAllByCnp(String cnp);
}
