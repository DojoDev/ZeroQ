package com.movile.zeroQ.stock.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movile.zeroQ.stock.domain.Product;
import com.movile.zeroQ.stock.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {

	@Autowired
	private ProductService productService;
	
	@GetMapping
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
	
}
