package com.movile.zeroQ.zoop.request;

public class TokenRequest {
	private String holder_name;
	 private String expiration_month;
	 private String expiration_year;
	 private String card_number;
	 private String security_code;


	 // Getter Methods 

	 public String getHolder_name() {
	  return holder_name;
	 }

	 public String getExpiration_month() {
	  return expiration_month;
	 }

	 public String getExpiration_year() {
	  return expiration_year;
	 }

	 public String getCard_number() {
	  return card_number;
	 }

	 public String getSecurity_code() {
	  return security_code;
	 }

	 // Setter Methods 

	 public void setHolder_name(String holder_name) {
	  this.holder_name = holder_name;
	 }

	 public void setExpiration_month(String expiration_month) {
	  this.expiration_month = expiration_month;
	 }

	 public void setExpiration_year(String expiration_year) {
	  this.expiration_year = expiration_year;
	 }

	 public void setCard_number(String card_number) {
	  this.card_number = card_number;
	 }

	 public void setSecurity_code(String security_code) {
	  this.security_code = security_code;
	 }
}
