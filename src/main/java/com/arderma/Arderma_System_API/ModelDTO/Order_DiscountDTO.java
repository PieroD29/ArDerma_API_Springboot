package com.arderma.Arderma_System_API.ModelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order_DiscountDTO {

	Long id;
	
	Long order_id;
	
	Long discount_id;
	
}
