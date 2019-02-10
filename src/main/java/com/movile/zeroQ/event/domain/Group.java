package com.movile.zeroQ.event.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.movile.zeroQ.financial.domain.Wallet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Group {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_group")
	private Integer id;
	@OneToMany(fetch = FetchType.LAZY)
	private List<Wallet> wallets;
	
}
