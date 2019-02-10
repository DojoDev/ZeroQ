package com.movile.zeroQ.financial.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.movile.zeroQ.financial.domain.Wallet;
import com.movile.zeroQ.financial.service.WalletService;

@RestController
@RequestMapping("/wallet")
@CrossOrigin
public class WalletResource {

	@Autowired
	private WalletService walletService;
	
	@GetMapping
	public List<Wallet> list() {
		return walletService.listAll();
	}

	@GetMapping("/{id}")
	public Wallet getWallet(@PathVariable("id") Integer id) {
		return walletService.findById(id).orElseGet(Wallet::new);
	}
	
	@GetMapping("/name={name}")
	public List<Wallet> getWallet(@PathVariable("name") String name) {
		return walletService.findByName(name);
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable("id") Integer id){
		walletService.remove(id);
	}
	
	@PutMapping("/{id}")
	public void remove(@PathVariable("id") Integer id, @Valid @RequestBody Wallet wallet){
		walletService.update(id,wallet);
	}
	
	@PostMapping
	public ResponseEntity<String> save(@Valid @RequestBody Wallet wallet, BindingResult result){

		if(result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		wallet.setId(0);
		walletService.save(wallet);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(wallet.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}
