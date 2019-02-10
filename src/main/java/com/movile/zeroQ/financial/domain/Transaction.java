package com.movile.zeroQ.financial.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_transaction")
	private Integer id;
	@Column(name="external_id")
	private String externalId;
	@Column(name="original_amount")
	private String originalAmount;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction", cascade = CascadeType.MERGE)
	private List<Wallet> wallets;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction", cascade = CascadeType.ALL)
	private List<ItemTransaction> itens;
	private Status status;
	
	public BigDecimal valueConsumed() {
		if(Objects.isNull(itens))return BigDecimal.ZERO;
		return itens.stream().map(ItemTransaction::getValue).reduce(BigDecimal.ZERO,BigDecimal::add);
	}
}
