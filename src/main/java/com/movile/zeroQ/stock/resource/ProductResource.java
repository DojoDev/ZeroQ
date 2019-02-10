package com.movile.zeroQ.stock.resource;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.movile.zeroQ.stock.domain.Product;
import com.movile.zeroQ.stock.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Product> list() {
		return productService.listAll();
	}

	@GetMapping("/{id}")
	public Product getEvent(@PathVariable("id") Integer id) {
		return productService.findById(id);
	}
	
	@GetMapping("/name={name}")
	public List<Product> getEvent(@PathVariable("name") String name) {
		return productService.findByName(name);
	}
	
	@DeleteMapping("/{id}")
	public void remove(@PathVariable("id") Integer id){
		productService.remove(id);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody Product product){
		productService.update(id, product);
	}
	
	@PostMapping
	public ResponseEntity<String> save(@Valid @RequestBody Product product, BindingResult result){

		if(result.hasErrors()) {
			return ResponseEntity.badRequest().build();
		}
		product.setId(0);
		productService.save(product);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(product.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}
	
}
