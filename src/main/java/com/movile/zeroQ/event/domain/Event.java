package com.movile.zeroQ.event.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="event",schema="event")
@AllArgsConstructor
@NoArgsConstructor
public class Event {

	@Id
	@GeneratedValue
	@Column(name="id_event")
	private Integer id;
	private String name;
	private LocalDate date;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_merchant",nullable=true)
	private List<Merchant> merchant;
}
