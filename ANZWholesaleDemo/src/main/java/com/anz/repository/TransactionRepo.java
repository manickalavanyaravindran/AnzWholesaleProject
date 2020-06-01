package com.anz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anz.entity.AccountTransactionEntity;

public interface TransactionRepo extends JpaRepository<AccountTransactionEntity, Integer> {
   List<AccountTransactionEntity> findByAccountNumber(long accountNumber);}
