package com.arderma.Arderma_System_API.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arderma.Arderma_System_API.ModelDTO.Order_DiscountDTO;
import com.arderma.Arderma_System_API.Service.Order_DiscountService;

@RestController
@RequestMapping("/api")
public class Order_DiscountController {

	private final Order_DiscountService service;
	
	public Order_DiscountController( Order_DiscountService service ) {
		this.service = service;
	}
	
	@GetMapping("/order_discount")
	public List<Order_DiscountDTO> getOrder_Discount(){
		return service.getOrder_Discount();
	}
	
	@PostMapping("/order_discount")
	public Order_DiscountDTO saveOrder_Discount( @RequestBody Order_DiscountDTO dto ) {
		return service.saveOrder_Discount(dto);
	}
	
	@DeleteMapping("/order_discount/{id}")
	public void deleteOrder_Discount( @PathVariable Long id ) {
		this.service.deleteOrder_Discount(id);
	}
	
}
