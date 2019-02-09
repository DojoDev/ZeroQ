package com.movile.zeroQ.event.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.movile.zeroQ.stock.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="merchant",schema="event")
@AllArgsConstructor
@NoArgsConstructor
public class Merchant {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	@OneToMany
	private List<Product> products;
}
