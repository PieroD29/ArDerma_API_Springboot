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

import com.arderma.Arderma_System_API.ModelDTO.PermissionDTO;
import com.arderma.Arderma_System_API.Service.PermissionService;

@RestController
@RequestMapping("/api")
public class PermissionController {

	private final PermissionService service;
	
	public PermissionController( PermissionService service ) {
		this.service = service;
	}
	
	@GetMapping("/permission")
	public List<PermissionDTO> getPermissions(){
		return service.getPermissions();
	}
	
	@PostMapping("/permission")
	public PermissionDTO createPermission( @RequestBody PermissionDTO dto ) {
		return service.savePermission(dto);
	}
	
	@PutMapping("/permission")
	public PermissionDTO updatePermission( @RequestBody PermissionDTO dto ) {
		return service.savePermission(dto);
	}
	
	@DeleteMapping("/permission/{id}")
	public void deletePermission( @PathVariable Long id ) {
		this.service.deletePermission(id);
	}
	
}
