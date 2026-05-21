package com.arderma.Arderma_System_API.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arderma.Arderma_System_API.Model.DocumentType;
import com.arderma.Arderma_System_API.Model.Role;
import com.arderma.Arderma_System_API.Model.User;
import com.arderma.Arderma_System_API.ModelDTO.UserDTO;
import com.arderma.Arderma_System_API.Repository.UserRepository;

@Service
public class UserService {

	private final UserRepository repository;
	
	public UserService( UserRepository repository ) {
		this.repository = repository;
		}
	
	public List<UserDTO> getUsers(){
		return repository.findAll()
				.stream()
				.map( u -> new UserDTO(
						u.getId(),
						u.getFirst_name(),
						u.getLast_name(), 
						u.getEmail(), 
						u.getDocument_number(), 
						u.getBirth_date(), 
						u.getPhone(), 
						u.isGender(), 
						u.getAddress(), 
						u.getPassword(), 
						u.getDocumenttype().getId(), 
						u.getRole().getId() ) 
					).collect(Collectors.toList());
	}
	
	public UserDTO saveUser( UserDTO dto ) {
		
		User user = new User();
		DocumentType documentType = new DocumentType();
		Role role = new Role();
		
		if ( dto.getId() != null ) user.setId( user.getId() );
		
		user.setFirst_name( dto.getFirst_name() );
		user.setLast_name( dto.getLast_name() );
		user.setEmail( dto.getEmail() );
		user.setDocument_number( dto.getDocument_number() );
		user.setBirth_date( dto.getBirth_date() );
		user.setPhone( dto.getPhone() );
		user.setGender( dto.isGender() );
		user.setAddress( dto.getAddress() );
		user.setPassword( dto.getPassword() );
	
		documentType.setId( dto.getDocument_type_id() );
		role.setId( dto.getRole_id() );
		
		user.setDocumenttype(documentType);
		user.setRole(role);
		
		User svUser = repository.save(user);
		
		return new UserDTO( svUser.getId(), 
				svUser.getFirst_name(), 
				svUser.getLast_name(), 
				svUser.getEmail(), 
				svUser.getDocument_number(), 
				svUser.getBirth_date(), 
				svUser.getPhone(), 
				svUser.isGender(), 
				svUser.getAddress(), 
				svUser.getPassword(), 
				svUser.getDocumenttype().getId(), 
				svUser.getRole().getId()
				);
		
	}
	
	public void deleteUser( Long id ) {
		this.repository.deleteById(id);
	}
	
}
