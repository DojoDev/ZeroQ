package com.movile.zeroQ.event.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.movile.zeroQ.financial.domain.Wallet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="event",schema="group")
@AllArgsConstructor
@NoArgsConstructor
public class Group {

	@Id
	@GeneratedValue
	@Column(name="id_group")
	private Integer id;
	@OneToOne
	@JoinColumn(name="id_event",nullable=true)
	private Event event;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_wallet",nullable=true)
	private List<Wallet> wallets;
	
}
