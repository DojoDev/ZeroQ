package com.movile.zeroQ.event.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Merchant {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_merchant")
	private Integer id;
	private String name;
}
