package com.movile.zeroQ.financial.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.movile.zeroQ.event.domain.Event;
import com.movile.zeroQ.event.domain.Group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Wallet {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_wallet")
	private Integer id;
	private String name;
	private String qr_code;
	private String card_information;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Transaction> transactions;
	@ManyToOne
	private Group group;
	@ManyToOne
	private Event event;
}
