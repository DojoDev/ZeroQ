package com.movile.zeroQ.financial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movile.zeroQ.financial.domain.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
