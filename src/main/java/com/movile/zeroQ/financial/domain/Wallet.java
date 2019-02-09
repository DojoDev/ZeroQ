package com.movile.zeroQ.financial.domain;

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
@Table(name = "wallet", schema = "financial")
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

	@Id
	@GeneratedValue
	private Integer id;
	private String name;
}
