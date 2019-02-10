package com.movile.zeroQ.zoop;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.movile.zeroQ.zoop.request.domain.TransactionRequest;
import com.movile.zeroQ.zoop.response.TransactionResponse;

public class TestClient {
	RestTemplate restTemplate = new RestTemplate();
	
    
	public void method() {
		TransactionRequest request2 = new TransactionRequest();
		request2.setAmount(1000.00f);
		request2.setCapture("false");
		request2.setCurrency("BRL");
		request2.setCustomer("138d7c62a6434cae906bfbed720a3e7a");
		request2.setDescription("Teste transação");
		request2.setOn_behalf_of("3c1050d692584bbe84a8fc86dd39782a");
		request2.setPayment_type("credit");
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic enBrX3Rlc3RfRXpDa3pGRktpYkdRVTZIRnE3RVlWdXhJOg==");      
		headers.set("Content-Type", "application/json");      

		HttpEntity<TransactionRequest> request = new HttpEntity<TransactionRequest>(request2, headers);
		
		
		ResponseEntity<TransactionResponse> quote = restTemplate.postForEntity("https://api.zoop.ws/v1/marketplaces/3249465a7753536b62545a6a684b0000/transactions", request, TransactionResponse.class);
				
		
		System.out.println(quote.getBody().getStatus());
		System.out.println(quote.getBody().getCreated_at());
	}

	public void method2() {
	TransactionRequest request2 = new TransactionRequest();
	request2.setAmount(1000.00f);
	request2.setCapture("false");
	request2.setCurrency("BRL");
	request2.setCustomer("138d7c62a6434cae906bfbed720a3e7a");
	request2.setDescription("Teste transação");
	request2.setOn_behalf_of("3c1050d692584bbe84a8fc86dd39782a");
	request2.setPayment_type("credit");
	
	ResponseEntity<TransactionResponse> new_response = method3(request2);
	
	
	System.out.println(new_response.getBody().getStatus());
	System.out.println(new_response.getBody().getCreated_at());
}

//	Confirmação da compra
	private ResponseEntity<TransactionResponse> method3(TransactionRequest request_old) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic enBrX3Rlc3RfRXpDa3pGRktpYkdRVTZIRnE3RVlWdXhJOg==");      
		headers.set("Content-Type", "application/json");      

		HttpEntity<TransactionRequest> request_new = new HttpEntity<TransactionRequest>(request_old, headers);
		
		ResponseEntity<TransactionResponse> quote = restTemplate.postForEntity("https://api.zoop.ws/v1/marketplaces/3249465a7753536b62545a6a684b0000/transactions", request_new, TransactionResponse.class);
				
		request_old.setAmount(10.00f);
		request_old.setCapture("true");
		
		String new_url = "https://api.zoop.ws/v1/marketplaces/3249465a7753536b62545a6a684b0000/transactions/"+quote.getBody().getId()+"/capture";
		
		ResponseEntity<TransactionResponse> new_response = restTemplate.postForEntity(new_url, request_new, TransactionResponse.class);
		return new_response;
	}
	
    public static void main(String[] args) {
		TestClient teste = new TestClient();
		
		teste.method2();
	}
}
