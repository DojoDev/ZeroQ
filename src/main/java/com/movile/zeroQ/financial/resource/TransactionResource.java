package com.movile.zeroQ.financial.resource;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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

import com.movile.zeroQ.financial.domain.Transaction;
import com.movile.zeroQ.financial.domain.Wallet;
import com.movile.zeroQ.financial.service.TransactionService;

@RestController
@RequestMapping("/transactions")
@CrossOrigin
public class TransactionResource {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping
	public List<Transaction> list() {
		return transactionService.listAll();
	}

	@GetMapping("/{id}")
	public Transaction getTransaction(@PathVariable("id") Integer id) {
		return transactionService.findById(id).orElseGet(Transaction::new);
	}

	@PostMapping("/checkin")
	public ResponseEntity<String> checkin(@Valid @RequestBody Wallet wallet,@RequestBody BigDecimal preApproved, BindingResult result){
		
		if(result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		transactionService.initializeTransaction(wallet,preApproved);

		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/checkout/{id}")
	public void checkout(@PathVariable("id") Integer id){
		Transaction transaction = getTransaction(id);
		if(Objects.isNull(transaction.getId()) || transaction.getId().equals(0))
		transactionService.finalizeTransaction(transaction);
	}
}
