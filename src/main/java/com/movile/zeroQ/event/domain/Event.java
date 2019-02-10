package com.movile.zeroQ.event.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.movile.zeroQ.financial.domain.Wallet;
import com.movile.zeroQ.stock.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Event {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_event")
	private Integer id;
	private String name;
	@DateTimeFormat(iso =ISO.DATE)
	@JsonFormat(pattern = "YYYY-MM-dd")
	private Date date;
	@OneToOne(cascade = CascadeType.ALL)
	private Merchant merchant;
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.MERGE)
	private List<Wallet> wallets;
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Product> products;
}
