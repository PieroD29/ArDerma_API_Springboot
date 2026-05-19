package com.arderma.Arderma_System_API.ModelDTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class OrdersDTO {

	Long id;
	
	float subtotal;
	
	float shipping;
	
	float total;
	
	Date created_at;
	
	Date updated_at;
	
	boolean status;
	
	Long laboratory_id;
	
	Long advisor_id;
	
	Long customer_id;
	
	Long processstatus_id;
	
}
