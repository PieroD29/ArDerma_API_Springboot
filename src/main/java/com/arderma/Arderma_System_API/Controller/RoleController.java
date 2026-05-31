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

import com.arderma.Arderma_System_API.ModelDTO.RoleDTO;
import com.arderma.Arderma_System_API.Service.RoleService;

@RestController
@RequestMapping("/api")
public class RoleController {

	private final RoleService service;
	
	public RoleController( RoleService service ) {
		this.service = service;
	}
	
	@GetMapping("/role")
	public List<RoleDTO> getRoles(){
		return service.getRoles();
	}
	
	@PostMapping("/role")
	public RoleDTO createRole( @RequestBody RoleDTO dto ) {
		return service.saveRole(dto);
	}
	
	@PutMapping("/role")
	public RoleDTO updateRole( @RequestBody RoleDTO dto ) {
		return service.saveRole(dto);
	}
	
	@DeleteMapping("/role/{id}")
	public void deleteRole( @PathVariable Long id ) {
		this.service.deleteRole(id);
	}
	
}
