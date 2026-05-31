package com.arderma.Arderma_System_API.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arderma.Arderma_System_API.Model.Role;
import com.arderma.Arderma_System_API.ModelDTO.RoleDTO;
import com.arderma.Arderma_System_API.Repository.RoleRepository;

@Service
public class RoleService {

	private final RoleRepository repository;
	
	public RoleService( RoleRepository repository ) {
		this.repository = repository;
	}
	
	public List<RoleDTO> getRoles(){
		return repository.findAll()
				.stream()
				.map( r -> new RoleDTO(
						r.getId(),
						r.getName(),
						r.getDescription(),
						r.getCreated_at(),
						r.getUpdated_at(),
						r.isStatus() ) )
				.collect(Collectors.toList());
	}
	
	public RoleDTO saveRole( RoleDTO dto ) {
		
		Role role = new Role();
		
		if ( dto.getId() != null ) role.setId( dto.getId() );
		
		role.setName( dto.getName() );
		role.setDescription( dto.getDescription() );
		role.setCreated_at( dto.getCreated_at() );
		role.setUpdated_at( dto.getUpdated_at() );
		role.setStatus( dto.isStatus() );
		
		Role svRole = repository.save(role);
		
		return new RoleDTO( svRole.getId(),
				svRole.getName(),
				svRole.getDescription(),
				svRole.getCreated_at(),
				svRole.getUpdated_at(),
				svRole.isStatus()
				);
	}
	
	public void deleteRole( Long id ) {
		this.repository.deleteById(id);
	}
	
}
