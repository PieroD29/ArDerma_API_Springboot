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

import com.arderma.Arderma_System_API.ModelDTO.Receipt_TypeDTO;
import com.arderma.Arderma_System_API.Service.Receipt_TypeService;

@RestController
@RequestMapping("/api")
public class Receipt_TypeController {

	private final Receipt_TypeService service;
	
	public Receipt_TypeController( Receipt_TypeService service ) {
		this.service = service;
	}
	
	@GetMapping("/receipt_type")
	public List<Receipt_TypeDTO> getReceipt_Type(){
		return service.getReceipt_Type();
	}
	
	@PostMapping("/receipt_type")
	public Receipt_TypeDTO createReceipt_Type( @RequestBody Receipt_TypeDTO dto ) {
		return service.saveReceipt_Type(dto);
	}
	
	@PutMapping("/receipt_type")
	public Receipt_TypeDTO updateReceipt_Type( @RequestBody Receipt_TypeDTO dto ) {
		return service.saveReceipt_Type(dto);
	}
	
	@DeleteMapping("/receipt_type/{id}")
	public void deleteReceipt_Type( @PathVariable Long id ) {
		this.service.deleteReceipt_Type(id);
	}
	
}
