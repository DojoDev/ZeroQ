package com.movile.zeroQ.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movile.zeroQ.stock.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
