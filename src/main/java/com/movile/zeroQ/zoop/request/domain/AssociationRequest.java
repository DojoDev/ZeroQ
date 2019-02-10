package com.movile.zeroQ.zoop.request.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssociationRequest {
	private String token;
	private String customer;
}
