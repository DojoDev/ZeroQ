package com.movile.zeroQ.financial.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.movile.zeroQ.financial.domain.Status;
import com.movile.zeroQ.financial.domain.Transaction;
import com.movile.zeroQ.financial.domain.Wallet;
import com.movile.zeroQ.financial.repository.ItemTransactionRepository;
import com.movile.zeroQ.financial.repository.TransactionRepository;
import com.movile.zeroQ.zoop.response.TransactionResponse;
import com.movile.zeroQ.zoop.task.TransactionTask;

@Service
public class TransactionService {

	@Autowired private TransactionRepository transactionRepository;
	@Autowired private ItemTransactionRepository itemTransactionRepository;
	@Autowired private TransactionTask transactionTask;
	
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
		transactionRepository.findById(id).ifPresent(ev -> transactionRepository.delete(ev));
	}
	
	public void initializeTransaction(Wallet wallet, BigDecimal preApproved) {
		TransactionResponse initializeTransaction = transactionTask.initializeTransaction(preApproved);
		Transaction transaction = TransactionParse.of(initializeTransaction);
		transaction.setWallets(Lists.newArrayList(wallet));
		transactionRepository.save(transaction);
	}

	public void finalizeTransaction(Transaction transaction) {
		transactionTask.finalizeTransaction(transaction.getExternalId(),transaction.valueConsumed());
		transaction.getItens().forEach(it -> it.setStatus(Status.PAGA));
		save(transaction);
	}

}
