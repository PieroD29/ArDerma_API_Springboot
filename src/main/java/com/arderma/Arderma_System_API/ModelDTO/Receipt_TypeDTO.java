package com.arderma.Arderma_System_API.ModelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Receipt_TypeDTO {

	Long id;
	
	String receipt_type;
	
	boolean status;
	
}
