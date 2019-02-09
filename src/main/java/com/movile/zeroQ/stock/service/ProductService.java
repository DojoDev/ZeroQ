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
	
	public List<Product> listAll() {
		return productRepository.findAll();
	}

	public Product findById(Integer id) {
		return productRepository.findById(id).orElseGet(Product::new);
	}

	public List<Product> findByName(String name) {
		return productRepository.findByName(name);
	}

}
