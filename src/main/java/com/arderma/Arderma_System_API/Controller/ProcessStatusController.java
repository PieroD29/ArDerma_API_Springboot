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

import com.arderma.Arderma_System_API.ModelDTO.ProcessStatusDTO;
import com.arderma.Arderma_System_API.Service.ProcessStatusService;

@RestController
@RequestMapping("/api")
public class ProcessStatusController {

	private final ProcessStatusService service;
	
	public ProcessStatusController( ProcessStatusService service ) {
		this.service = service;
	}
	
	@GetMapping("/processstatus")
	public List<ProcessStatusDTO> getProcessStatus(){
		return service.getProcessStatus();
	}
	
	@PostMapping("/processstatus")
	public ProcessStatusDTO createProcessStatus( @RequestBody ProcessStatusDTO dto ) {
		return service.saveProcessStatus(dto);
	}
	
	@PutMapping("/processstatus")
	public ProcessStatusDTO updateProcessStatus( @RequestBody ProcessStatusDTO dto ) {
		return service.saveProcessStatus(dto);
	}
	
	@DeleteMapping("/processstatus/{id}")
	public void deleteProcessStatus( @PathVariable Long id ) {
		this.service.deleteProcessStatus(id);
	}
	
}
