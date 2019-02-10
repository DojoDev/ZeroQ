package com.movile.zeroQ.zoop.request.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenRequest {
	private String holder_name;
	private String expiration_month;
	private String expiration_year;
	private String card_number;
	private String security_code;
}
