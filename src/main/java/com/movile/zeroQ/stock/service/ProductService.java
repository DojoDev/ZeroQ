package com.movile.zeroQ.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movile.zeroQ.stock.domain.Product;
import com.movile.zeroQ.stock.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	
	public void save(Product product) {
		productRepository.save(product);
	}
	
	public List<Product> listAll() {
		return productRepository.findAll();
	}

	public Product findById(Integer id) {
		return productRepository.findById(id).orElseGet(Product::new);
	}

	public List<Product> findByName(String name) {
		return productRepository.findByName(name);
	}

	public void remove(Integer id) {
		productRepository.findById(id).ifPresent(p -> {
			productRepository.delete(p);
		});
	}
	
	public void update(Integer id,Product product) {
		productRepository.findById(id).ifPresent(p -> {
			product.setId(id);
			save(product);
		});
	}

}
