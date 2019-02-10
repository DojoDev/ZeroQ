package com.movile.zeroQ.financial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movile.zeroQ.financial.domain.ItemTransaction;
import com.movile.zeroQ.financial.domain.Transaction;

public interface ItemTransactionRepository extends JpaRepository<ItemTransaction, Integer>{

	public List<ItemTransaction> findByTransaction(Transaction transaction);
	public List<ItemTransaction> findByDescription(String description);
}
