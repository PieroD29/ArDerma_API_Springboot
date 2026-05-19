package com.arderma.Arderma_System_API.ModelDTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class SaleDTO {

	Long id;
	
	String receipt_sale;
	
	float billed_amount;
	
	String payment_conditions;
	
	Date created_at;
	
	Date updated_at;
	
	boolean status;
	
	Long receipt_type_id;
	
	Long order_id;
	
}
