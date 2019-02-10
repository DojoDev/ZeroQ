package com.movile.zeroQ.financial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movile.zeroQ.financial.domain.Transaction;
import com.movile.zeroQ.financial.domain.Wallet;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
	
	List<Transaction> findByWallet(Wallet wallet);
}
