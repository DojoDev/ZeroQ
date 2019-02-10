package com.movile.zeroQ.zoop.request.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

	private String currency;
	private String description;
	private String payment_type;
	private String capture;
	private String on_behalf_of;
	private float amount;
	private String customer;

}
