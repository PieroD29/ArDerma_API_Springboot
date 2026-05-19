package com.arderma.Arderma_System_API.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arderma.Arderma_System_API.ModelDTO.UserDTO;
import com.arderma.Arderma_System_API.Service.UserService;

@RestController
@RequestMapping("api")
public class UserController {

	private final UserService service;
	
	public UserController( UserService service ) {
		this.service = service;
	}
	
	@GetMapping("user")
	public List<UserDTO> getUsers(){
		return service.getUsers();
	}

	@PostMapping("user")
	public UserDTO createUser( @RequestBody UserDTO dto ) {
		return service.saveUser(dto);
	}
	
}
