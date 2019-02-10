package com.movile.zeroQ.zoop.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class TransactionResponse {
	private String id;
	private String status;
	private String amount;
	private String original_amount;
	private String currency;
	private String description;
	private String transaction_number;
	private String on_behalf_of;
	private String customer;
	private String expected_on;
	private String created_at;
	private String updated_at;

}