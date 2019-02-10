package com.movile.zeroQ.financial.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.google.common.collect.Lists;
import com.movile.zeroQ.financial.domain.ItemTransaction;
import com.movile.zeroQ.financial.domain.Transaction;
import com.movile.zeroQ.financial.service.ItemService;
import com.movile.zeroQ.financial.service.TransactionService;

@RestController
@RequestMapping("/item-transactions")
@CrossOrigin
public class ItemTransactionResource {

	@Autowired private ItemService itemService;
	@Autowired private TransactionService transactionService;
	
	@GetMapping
	public List<ItemTransaction> list() {
		return itemService.listAll();
	}

	@GetMapping("/{id}")
	public ItemTransaction getItem(@PathVariable("id") Integer id) {
		return itemService.findById(id).orElseGet(ItemTransaction::new);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<String> appendItem(@PathVariable("id") Integer idTransaction, @Valid @RequestBody ItemTransaction item, BindingResult result){

		if(result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		
		item.setId(0);
		Optional<Transaction> transaction = transactionService.findById(idTransaction);
		if(transaction.isPresent()) return ResponseEntity.badRequest().build();
		
		item.setTransaction(transaction.get());
		itemService.insertItems(Lists.newArrayList(item));
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(item.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
}
