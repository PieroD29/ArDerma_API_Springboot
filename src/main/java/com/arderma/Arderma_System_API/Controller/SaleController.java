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

import com.arderma.Arderma_System_API.ModelDTO.SaleDTO;
import com.arderma.Arderma_System_API.Service.SaleService;

@RestController
@RequestMapping("/api")
public class SaleController {

	private final SaleService service;
	
	public SaleController( SaleService service ) {
		this.service = service;
	}
	
	@GetMapping("/sale")
	public List<SaleDTO> getSales(){
		return service.getSales();
	}
	
	@PostMapping("/sale")
	public SaleDTO createSale( @RequestBody SaleDTO dto ) {
		return service.saveSale(dto);
	}
	
	@PutMapping("/sale")
	public SaleDTO updateSale( @RequestBody SaleDTO dto ) {
		return service.saveSale(dto);
	}
	
	@DeleteMapping("/sale/{id}")
	public void deleteSale( @PathVariable Long id ) {
		this.service.deleteUser(id);
	}
	
}
