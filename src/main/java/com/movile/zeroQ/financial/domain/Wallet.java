package com.movile.zeroQ.financial.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.movile.zeroQ.event.domain.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="wallet",schema="financial")
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

	@Id
	@GeneratedValue
	@Column(name="id_wallet")
	private Integer id;
	private String name;
	private String qr_code;
	private String card_information;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_event",nullable=true)
	private List<Event> events;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_transaction",nullable=true)
	private List<Transaction> transactions;
}
