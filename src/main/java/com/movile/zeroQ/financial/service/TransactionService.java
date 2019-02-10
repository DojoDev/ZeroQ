package com.movile.zeroQ.financial.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movile.zeroQ.financial.domain.Transaction;
import com.movile.zeroQ.financial.repository.ItemTransactionRepository;
import com.movile.zeroQ.financial.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired private TransactionRepository transactionRepository;
	@Autowired private ItemTransactionRepository itemTransactionRepository;
	
	public List<Transaction> listAll() {
		return transactionRepository.findAll().stream().peek(t ->{
			t.setItens(itemTransactionRepository.findByTransaction(t));
		}).collect(Collectors.toList());
	}

	public Optional<Transaction> findById(Integer id) {
		Optional<Transaction> transaction =  transactionRepository.findById(id);
		
		transaction.ifPresent(t ->{
			t.setItens(itemTransactionRepository.findByTransaction(t));
		});
		
		return transaction;
	}
	
	public void save(Transaction transaction) {
		transactionRepository.save(transaction);
		
	}

	public void remove(Integer id) {
		Optional<Transaction> transaction = transactionRepository.findById(id);
		transaction.ifPresent(ev ->{
			transactionRepository.delete(ev);
		});
	}

}
