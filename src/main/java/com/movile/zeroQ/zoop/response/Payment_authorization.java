package com.movile.zeroQ.zoop.response;

public class Payment_authorization {
	 private String authorizer_id;
	 private String authorization_code;
	 private String authorization_nsu;


	 // Getter Methods 

	 public String getAuthorizer_id() {
	  return authorizer_id;
	 }

	 public String getAuthorization_code() {
	  return authorization_code;
	 }

	 public String getAuthorization_nsu() {
	  return authorization_nsu;
	 }

	 // Setter Methods 

	 public void setAuthorizer_id(String authorizer_id) {
	  this.authorizer_id = authorizer_id;
	 }

	 public void setAuthorization_code(String authorization_code) {
	  this.authorization_code = authorization_code;
	 }

	 public void setAuthorization_nsu(String authorization_nsu) {
	  this.authorization_nsu = authorization_nsu;
	 }
	}