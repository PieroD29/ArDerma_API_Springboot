package com.arderma.Arderma_System_API.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arderma.Arderma_System_API.Model.Permission;
import com.arderma.Arderma_System_API.Model.Role;
import com.arderma.Arderma_System_API.Model.Role_Permission;
import com.arderma.Arderma_System_API.ModelDTO.Role_PermissionDTO;
import com.arderma.Arderma_System_API.Repository.Role_PermissionRepository;

@Service
public class Role_PermissionService {

	private final Role_PermissionRepository repository;
	
	public Role_PermissionService( Role_PermissionRepository repository ) {
		this.repository = repository;
	}
	
	public List<Role_PermissionDTO> getRole_Permission(){
		return repository.findAll()
				.stream()
				.map( rp -> new Role_PermissionDTO( rp.getId(),
						rp.getRole().getId(),
						rp.getPermission().getId()) )
				.collect(Collectors.toList());
	}
	
	public Role_PermissionDTO saveRole_Permission( Role_PermissionDTO dto ) {
		Role_Permission role_permission = new Role_Permission();
		Role role = new Role();
		Permission permission = new Permission();
		
		if ( dto.getId() != null ) role_permission.setId( dto.getId() );
		
		role.setId( dto.getRole_id() );
		permission.setId( dto.getPermission_id() );
		
		role_permission.setRole(role);
		role_permission.setPermission(permission);
		
		Role_Permission svRt = repository.save(role_permission);
		
		return new Role_PermissionDTO(svRt.getId(),
				svRt.getRole().getId(),
				svRt.getPermission().getId()
				);
	}
	
	public void deleteRole_Permission( Long id ) {
		this.repository.deleteById(id);
	}
	
}
