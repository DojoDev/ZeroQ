package com.movile.zeroQ.zoop.task;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.movile.zeroQ.zoop.request.domain.TransactionRequest;
import com.movile.zeroQ.zoop.response.TransactionResponse;

@Component
public class TransactionTask {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${urlZoop}") private String urlZoop;
	@Value("${currency}") private String currency;
	@Value("${customer}") private String customer;
	@Value("${behalf_of}") private String behalfOf;

	public TransactionResponse sendTransaction(TransactionRequest TransactionRequest) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic enBrX3Rlc3RfRXpDa3pGRktpYkdRVTZIRnE3RVlWdXhJOg==");
		headers.set("Content-Type", "application/json");

		HttpEntity<TransactionRequest> request = new HttpEntity<TransactionRequest>(TransactionRequest, headers);

		ResponseEntity<TransactionResponse> quote = restTemplate.postForEntity(urlZoop, request,
				TransactionResponse.class, "transactions");

		return quote.getBody();
	}

	public TransactionResponse finalizeTransaction(BigDecimal reserve) {
		TransactionRequest transactionRequest = buildTransaction();
		transactionRequest.setCapture("true");
		transactionRequest.setAmount(reserve.floatValue());
		return sendTransaction(transactionRequest);
	}

	public TransactionResponse initializeTransaction(BigDecimal reserve) {
		TransactionRequest transactionRequest = buildTransaction();
		transactionRequest.setAmount(reserve.floatValue());
		return sendTransaction(transactionRequest);
	}
	
	private TransactionRequest buildTransaction() {
		return TransactionRequest.builder()
				.currency(currency)
				.customer(customer)
				.on_behalf_of(behalfOf)
				.capture("false")
				.build();
	}
}
