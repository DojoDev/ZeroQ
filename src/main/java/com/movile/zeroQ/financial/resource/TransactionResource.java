package com.movile.zeroQ.financial.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.movile.zeroQ.financial.domain.Transaction;
import com.movile.zeroQ.financial.service.TransactionService;

@RestController
@RequestMapping("/transactions")
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

	@DeleteMapping("/{id}")
	public void remove(@PathVariable("id") Integer id){
		transactionService.remove(id);
	}

	@PostMapping
	public ResponseEntity<String> save(@Valid @RequestBody Transaction transaction, BindingResult result){

		if(result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		transaction.setId(0);
		transactionService.save(transaction);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(transaction.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
}
