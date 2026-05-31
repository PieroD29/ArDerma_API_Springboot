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

import com.arderma.Arderma_System_API.ModelDTO.LaboratoryDTO;
import com.arderma.Arderma_System_API.Service.LaboratoryService;

@RestController
@RequestMapping("/api")
public class LaboratoryController {

	private final LaboratoryService service;
	
	public LaboratoryController( LaboratoryService service ) {
		this.service = service;
	}
	
	@GetMapping("/laboratory")
	public List<LaboratoryDTO> getLaboratories(){
		return service.getLaboratories();
	}
	
	@PostMapping("/laboratory")
	public LaboratoryDTO createLaboratory( @RequestBody LaboratoryDTO dto ) {
		return service.saveLaboratory(dto);
	}
	
	@PutMapping("/laboratory")
	public LaboratoryDTO updateLaboratory( @RequestBody LaboratoryDTO dto ) {
		return service.saveLaboratory(dto);
	}
	
	@DeleteMapping("/laboratory/{id}")
	public void deleteLaboratory( @PathVariable Long id ) {
		this.service.deleteLaboratory(id);
	}
	
}
