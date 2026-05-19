package com.arderma.Arderma_System_API.ModelDTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Order_ProductDTO {

	Long id;

	int quantity;
	
	Date created_at;
	
	Date updated_at;
	
	Long product_id;
	
	Long order_id;
	
}
