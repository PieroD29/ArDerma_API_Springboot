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

import com.arderma.Arderma_System_API.ModelDTO.PaymentDetailDTO;
import com.arderma.Arderma_System_API.Service.PaymentDetailService;

@RestController
@RequestMapping("/api")
public class PaymentDetailController {

	private final PaymentDetailService service;
	
	public PaymentDetailController( PaymentDetailService service ) {
		this.service = service;
	}
	
	@GetMapping("/paymentdetail")
	public List<PaymentDetailDTO> getPaymentDetails(){
		return service.getPaymentDetails();
	}
	
	@PostMapping("/paymentdetail")
	public PaymentDetailDTO createPaymentDetail( @RequestBody  PaymentDetailDTO dto ) {
		return service.savePaymentDetail(dto);
	}
	
	@PutMapping("/paymentdetail")
	public PaymentDetailDTO updatePaymentDetail( @RequestBody PaymentDetailDTO dto ) {
		return service.savePaymentDetail(dto);
	}
	
	@DeleteMapping("/paymentdetail/{id}")
	public void deletePaymentDetail( @PathVariable Long id ) {
		this.service.deletePaymentDetail(id);
	}
	
}
