package com.movile.zeroQ.zoop.request;

public class TransactionRequest {
	private String currency;
	 private String description;
	 private String payment_type;
	 private String capture;
	 private String on_behalf_of;
	 private float amount;
	 private String customer;


	 // Getter Methods 

	 public String getCurrency() {
	  return currency;
	 }

	 public String getDescription() {
	  return description;
	 }

	 public String getPayment_type() {
	  return payment_type;
	 }

	 public String getCapture() {
	  return capture;
	 }

	 public String getOn_behalf_of() {
	  return on_behalf_of;
	 }

	 public float getAmount() {
	  return amount;
	 }

	 public String getCustomer() {
	  return customer;
	 }

	 // Setter Methods 

	 public void setCurrency(String currency) {
	  this.currency = currency;
	 }

	 public void setDescription(String description) {
	  this.description = description;
	 }

	 public void setPayment_type(String payment_type) {
	  this.payment_type = payment_type;
	 }

	 public void setCapture(String capture) {
	  this.capture = capture;
	 }

	 public void setOn_behalf_of(String on_behalf_of) {
	  this.on_behalf_of = on_behalf_of;
	 }

	 public void setAmount(float amount) {
	  this.amount = amount;
	 }

	 public void setCustomer(String customer) {
	  this.customer = customer;
	 }

}
