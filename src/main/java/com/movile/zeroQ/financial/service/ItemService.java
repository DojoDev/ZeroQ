package com.movile.zeroQ.financial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movile.zeroQ.financial.domain.ItemTransaction;
import com.movile.zeroQ.financial.domain.Status;
import com.movile.zeroQ.financial.repository.ItemTransactionRepository;

@Service
public class ItemService {
	
	@Autowired private ItemTransactionRepository itemTransactionRepository;
	
	public void insertItems(List<ItemTransaction> items) {
		
		for (ItemTransaction itemTransaction : items) {
			itemTransaction.setStatus(Status.SOLICITADA);
		}
		itemTransactionRepository.saveAll(items);
	}

	public List<ItemTransaction> listAll() {
		return itemTransactionRepository.findAll();
	}

	public Optional<ItemTransaction> findById(Integer id) {
		return itemTransactionRepository.findById(id);
	}

}
