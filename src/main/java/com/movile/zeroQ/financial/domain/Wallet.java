package com.movile.zeroQ.financial.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.movile.zeroQ.event.domain.Event;
import com.movile.zeroQ.event.domain.MyGroup;

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
	@OneToMany(fetch = FetchType.LAZY,mappedBy ="wallet")
	@Fetch(FetchMode.SUBSELECT)
	private List<Transaction> transactions;
	@ManyToOne
	@JoinColumn(name = "id_group")
	@LazyCollection(LazyCollectionOption.TRUE)
	private MyGroup myGroup;
	@ManyToOne
	@JoinColumn(name = "id_event")
	@LazyCollection(LazyCollectionOption.TRUE)
	private Event event;
}
