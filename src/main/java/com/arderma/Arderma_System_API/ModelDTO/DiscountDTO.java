package com.arderma.Arderma_System_API.ModelDTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DiscountDTO {

	Long id;
	
	String reason;
	
	String description;
	
	float percentage;
	
	Date created_at;
	
	Date updated_at;
	
	boolean status;
	
}
