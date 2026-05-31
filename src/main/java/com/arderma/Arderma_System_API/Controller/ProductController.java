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

import com.arderma.Arderma_System_API.ModelDTO.ProductDTO;
import com.arderma.Arderma_System_API.Service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	private final ProductService service;
	
	public ProductController( ProductService service ) {
		this.service = service;
	}
	
	@GetMapping("/product")
	public List<ProductDTO> getProducts(){
		return service.getProducts();
	}
	
	@PostMapping("/product")
	public ProductDTO createProduct( @RequestBody ProductDTO dto ) {
		return service.saveProduct(dto);
	}
	
	@PutMapping("/product")
	public ProductDTO updateProduct( @RequestBody ProductDTO dto) {
		return service.saveProduct(dto);
	}
	
	@DeleteMapping("/product/{id}")
	public void deleteProduct( @PathVariable Long id ) {
		this.service.deleteProduct(id);
	}
	
}
