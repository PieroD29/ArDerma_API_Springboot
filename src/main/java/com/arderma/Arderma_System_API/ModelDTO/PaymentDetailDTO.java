package com.arderma.Arderma_System_API.ModelDTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PaymentDetailDTO {

	Long id;
	
	String operation_number;
	
	Date payment_date;
	
	float collected_amount;
	
	String dermablock_units;
	
	String observation;
	
	Date created_at;
	
	Date updated_at;
	
	boolean status;
	
	Long sales_id;
	
	Long payment_method_id;
	
}
