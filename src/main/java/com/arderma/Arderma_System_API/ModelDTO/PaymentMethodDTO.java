package com.arderma.Arderma_System_API.ModelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentMethodDTO {

	Long id;
	
	String payment_method;
	
	boolean status;
	
}
