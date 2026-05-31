
package com.arderma.Arderma_System_API.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arderma.Arderma_System_API.Model.Product;
import com.arderma.Arderma_System_API.ModelDTO.ProductDTO;
import com.arderma.Arderma_System_API.Repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository repository;
	
	public ProductService ( ProductRepository repository ) {
		this.repository = repository; 
	}
	 
	public List<ProductDTO> getProducts(){
		return repository.findAll()
				.stream()
				.map( p -> new ProductDTO(p.getId(),
						p.getName(),
						p.getPrice(),
						p.getCode(),
						p.getStock(),
						p.getDescription(),
						p.getImage(),
						p.is_customizable(),
						p.getCreated_at(),
						p.getUpdated_at(),
						p.isStatus()) )
				.collect( Collectors.toList() );
	}
	
	public ProductDTO saveProduct( ProductDTO dto ) {
		Product product = new Product();
		
		if ( dto.getId() != null ) product.setId( dto.getId() );
		
		product.setName( dto.getName() );
		product.setPrice( dto.getPrice() );
		product.setCode( dto.getCode() );
		product.setStock( dto.getStock() );
		product.setDescription( dto.getDescription() );
		product.setImage( dto.getImage() );
		product.set_customizable( dto.is_customizable() );
		product.setCreated_at( dto.getCreated_at() );
		product.setUpdated_at( dto.getUpdated_at() );
		product.setStatus( dto.isStatus() );
		
		Product svProduct = repository.save(product);
		
		return new ProductDTO(svProduct.getId(),
				svProduct.getName(),
				svProduct.getPrice(),
				svProduct.getCode(),
				svProduct.getStock(),
				svProduct.getDescription(),
				svProduct.getImage(),
				svProduct.is_customizable(),
				svProduct.getCreated_at(),
				svProduct.getUpdated_at(),
				svProduct.isStatus()
				);
	}
	
	public void deleteProduct( Long id ) {
		this.repository.deleteById(id);
	}
	
}
