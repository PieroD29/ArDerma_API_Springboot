package com.arderma.Arderma_System_API.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arderma.Arderma_System_API.Model.Permission;
import com.arderma.Arderma_System_API.ModelDTO.PermissionDTO;
import com.arderma.Arderma_System_API.Repository.PermissionRepository;

@Service
public class PermissionService {

	private final PermissionRepository repository;
	
	public PermissionService( PermissionRepository repository ) {
		this.repository = repository;
	}
	
	public List<PermissionDTO> getPermissions(){
		return repository.findAll()
				.stream()
				.map( p -> new PermissionDTO(p.getId(),
						p.getAction(),
						p.getCreated_at(),
						p.getUpdated_at(),
						p.isStatus()) )
				.collect( Collectors.toList() );
	}
	
	public PermissionDTO savePermission( PermissionDTO dto ) {
		Permission permission = new Permission();
		
		if ( dto.getId() != null ) permission.setId( dto.getId() );
		
		permission.setAction( dto.getAction() );
		permission.setCreated_at( dto.getCreated_at() );
		permission.setUpdated_at( dto.getUpdated_at() );
		permission.setStatus( dto.isStatus() );
		
		Permission svPermission = repository.save(permission);
		
		return new PermissionDTO(svPermission.getId(),
				svPermission.getAction(),
				svPermission.getCreated_at(),
				svPermission.getUpdated_at(),
				svPermission.isStatus()
				);
	}
	
	public void deletePermission( Long id ) {
		this.repository.deleteById(id);
	}
	
}
