package com.movile.zeroQ.stock.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="product",schema="stock")
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue
	private Integer id;
	private BigDecimal price;
}
