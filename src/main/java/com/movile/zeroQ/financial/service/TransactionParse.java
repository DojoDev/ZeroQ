package com.movile.zeroQ.financial.service;

import com.movile.zeroQ.financial.domain.Transaction;
import com.movile.zeroQ.zoop.response.TransactionResponse;

public class TransactionParse {

	public static Transaction of(TransactionResponse transactionResponse) {
		return Transaction.builder()
			.externalId(transactionResponse.getId())
			.originalAmount(transactionResponse.getOriginal_amount())
			.build();
	}

}
