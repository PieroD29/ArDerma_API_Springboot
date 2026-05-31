package com.arderma.Arderma_System_API.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arderma.Arderma_System_API.ModelDTO.OrdersDTO;
import com.arderma.Arderma_System_API.Service.OrdersService;

@RestController
@RequestMapping("/api")
public class OrdersController {

	private final OrdersService service;
	
	public OrdersController( OrdersService service ) {
		this.service = service;
	}
	
	@GetMapping("/orders")
	public List<OrdersDTO> getOrders(){
		return service.getOrders();
	}
	
	@PostMapping("/orders")
	public OrdersDTO createOrder( @RequestBody OrdersDTO dto ) {
		return service.saveOrder(dto);
	}
	
	@PutMapping("/orders")
	public OrdersDTO updateOrder( @RequestBody OrdersDTO dto ) {
		return service.saveOrder(dto);
	}
	
	@DeleteMapping("/orders/{id}")
	public void deleteOrder( @PathVariable Long id ) {
		this.service.deleteOrder(id);
	}
	
}
