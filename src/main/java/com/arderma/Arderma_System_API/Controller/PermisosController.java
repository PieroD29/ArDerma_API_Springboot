package com.arderma.Arderma_System_API.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PermisosController {
	
	@GetMapping("permisos")
	public String getPermisos() {
		return "oliver kbro";
	}
	
}
