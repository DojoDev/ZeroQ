package com.movile.zeroQ.financial.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movile.zeroQ.financial.domain.Wallet;
import com.movile.zeroQ.financial.repository.WalletRepository;

@Service
public class WalletService {

	@Autowired
	private WalletRepository walletRepository;
	
	public List<Wallet> listAll() {
		return walletRepository.findAll();
	}

	public Optional<Wallet> findById(Integer id) {
		return walletRepository.findById(id);
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
