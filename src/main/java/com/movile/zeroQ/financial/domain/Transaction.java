package com.movile.zeroQ.financial.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_transaction")
	private Integer id;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction")
	private List<Wallet> wallets;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction",cascade=CascadeType.ALL)
	private List<ItemTransaction> itens;
	
}
