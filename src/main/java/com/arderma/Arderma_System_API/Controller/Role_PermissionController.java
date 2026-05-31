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

import com.arderma.Arderma_System_API.ModelDTO.Role_PermissionDTO;
import com.arderma.Arderma_System_API.Service.Role_PermissionService;

@RestController
@RequestMapping("/api")
public class Role_PermissionController {

	private final Role_PermissionService service;
	
	public Role_PermissionController( Role_PermissionService service ) {
		this.service = service;
	}
	
	@GetMapping("/role_permission")
	public List<Role_PermissionDTO> getRole_Permission(){
		return service.getRole_Permission();
	}
	
	@PostMapping("/role_permission")
	public Role_PermissionDTO createRole_Permission( @RequestBody Role_PermissionDTO dto ) {
		return service.saveRole_Permission(dto);
	}
	
	@PutMapping("/role_permission")
	public Role_PermissionDTO updateRole_Permission( @RequestBody Role_PermissionDTO dto ) {
		return service.saveRole_Permission(dto);
	}
	
	@DeleteMapping("/role_permission/{id}")
	public void deleteRole_Permission( @PathVariable Long id ) {
		this.service.deleteRole_Permission(id);
	}
	
}
