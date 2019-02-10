package com.movile.zeroQ.financial.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movile.zeroQ.financial.domain.Wallet;
import com.movile.zeroQ.financial.repository.TransactionRepository;
import com.movile.zeroQ.financial.repository.WalletRepository;

@Service
public class WalletService {

	@Autowired private WalletRepository walletRepository;
	@Autowired private TransactionRepository transactionRepository;
	
	public List<Wallet> listAll() {
		return walletRepository.findAll().stream().peek(w ->{
			w.setTransactions(transactionRepository.findByWallet(w));
		}).collect(Collectors.toList());
	}

	public Optional<Wallet> findById(Integer id) {
		Optional<Wallet> wallet =  walletRepository.findById(id);
		
		wallet.ifPresent(w ->{
			w.setTransactions(transactionRepository.findByWallet(w));
		});
		
		return wallet;
	}

	public List<Wallet> findByName(String name) {
		return walletRepository.findByName(name);
	}
	
	public void save(Wallet wallet) {
		walletRepository.save(wallet);
		
	}

	public void remove(Integer id) {
		Optional<Wallet> wallet = walletRepository.findById(id);
		wallet.ifPresent(ev ->{
			walletRepository.delete(ev);
		});
	}

	public void update(Integer id, @Valid Wallet wallet) {
		walletRepository.findById(id).ifPresent(ev ->{
			wallet.setId(id);
			save(wallet);
		});
	}

}
