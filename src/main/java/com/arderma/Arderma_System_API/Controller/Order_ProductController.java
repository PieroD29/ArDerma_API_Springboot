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

import com.arderma.Arderma_System_API.ModelDTO.Order_ProductDTO;
import com.arderma.Arderma_System_API.Service.Order_ProductService;

@RestController
@RequestMapping("/api")
public class Order_ProductController {

	private final Order_ProductService service;
	
	public Order_ProductController( Order_ProductService service ) {
		this.service = service;
	}
	
	@GetMapping("/order_product")
	public List<Order_ProductDTO> getOrder_ProductDTO(){
		return service.getOrder_Products();
	}
	
	@PostMapping("/order_product")
	public Order_ProductDTO createOrder_Product( @RequestBody Order_ProductDTO dto ) {
		return service.saveOrder_Product(dto);
	}
	
	@PutMapping("/order_product")
	public Order_ProductDTO updateOrder_Product( @RequestBody Order_ProductDTO dto ) {
		return service.saveOrder_Product(dto);
	}
	
	@DeleteMapping("/order_product/{id}")
	public void deleteOrder_Product( @PathVariable Long id ) {
		this.service.deleteOrder_Product(id);
	}
	
}
