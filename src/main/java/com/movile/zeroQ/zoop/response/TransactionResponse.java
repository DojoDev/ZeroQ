package com.movile.zeroQ.zoop.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getOriginal_amount() {
		return original_amount;
	}
	public void setOriginal_amount(String original_amount) {
		this.original_amount = original_amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTransaction_number() {
		return transaction_number;
	}
	public void setTransaction_number(String transaction_number) {
		this.transaction_number = transaction_number;
	}
	public String getOn_behalf_of() {
		return on_behalf_of;
	}
	public void setOn_behalf_of(String on_behalf_of) {
		this.on_behalf_of = on_behalf_of;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getExpected_on() {
		return expected_on;
	}
	public void setExpected_on(String expected_on) {
		this.expected_on = expected_on;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	 
	 

}