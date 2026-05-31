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

import com.arderma.Arderma_System_API.ModelDTO.PaymentMethodDTO;
import com.arderma.Arderma_System_API.Service.PaymentMethodService;

@RestController
@RequestMapping("/api")
public class PaymentMethodController {

	private final PaymentMethodService service;
	
	public PaymentMethodController( PaymentMethodService service ) {
		this.service = service;
	}
	
	@GetMapping("/paymentmethod")
	public List<PaymentMethodDTO> getPaymentMethods(){
		return service.getPaymentMehtods();
	}
	
	@PostMapping("/paymentmethod")
	public PaymentMethodDTO createPaymentMethod( @RequestBody PaymentMethodDTO dto ) {
		return service.savePaymentMethod(dto);
	}
	
	@PutMapping("/paymentmethod")
	public PaymentMethodDTO updatePaymentMethod( @RequestBody PaymentMethodDTO dto ) {
		return service.savePaymentMethod(dto);
	}
	
	@DeleteMapping("/paymentmethod/{id}")
	public void deletePaymentMethod( @PathVariable Long id ) {
		this.service.deletePaymentMethod(id);
	}
	
}
