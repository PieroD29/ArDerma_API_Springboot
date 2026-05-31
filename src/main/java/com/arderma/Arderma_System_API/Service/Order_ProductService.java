package com.arderma.Arderma_System_API.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arderma.Arderma_System_API.Model.Order_Product;
import com.arderma.Arderma_System_API.Model.Orders;
import com.arderma.Arderma_System_API.Model.Product;
import com.arderma.Arderma_System_API.ModelDTO.Order_ProductDTO;
import com.arderma.Arderma_System_API.Repository.Order_ProductRepository;

@Service
public class Order_ProductService {

	private final Order_ProductRepository repository;
	
	public Order_ProductService( Order_ProductRepository repository ) {
		this.repository = repository;
	}
	
	public List<Order_ProductDTO> getOrder_Products(){
		return repository.findAll()
				.stream()
				.map( op -> new Order_ProductDTO(op.getId(),
						op.getQuantity(),
						op.getCreated_at(),
						op.getUpdated_at(),
						op.getProduct().getId(),
						op.getOrders().getId()) )
				.collect( Collectors.toList() );
	}
	
	public Order_ProductDTO saveOrder_Product( Order_ProductDTO dto ) {
		Order_Product order_product = new Order_Product();
		Product product = new Product();
		Orders order = new Orders();
		
		if ( dto.getId() != null ) order_product.setId( dto.getId() );
		
		order_product.setQuantity( dto.getQuantity() );
		order_product.setCreated_at( dto.getCreated_at() );
		order_product.setUpdated_at( dto.getUpdated_at() );
		
		product.setId( dto.getProduct_id() );
		order.setId( dto.getOrder_id() );
		
		order_product.setProduct(product);
		order_product.setOrders(order);
		
		Order_Product svOp = repository.save(order_product);
		
		return new Order_ProductDTO(svOp.getId(),
				svOp.getQuantity(),
				svOp.getCreated_at(),
				svOp.getUpdated_at(),
				svOp.getProduct().getId(),
				svOp.getOrders().getId()
				);
	}
	
	public void deleteOrder_Product( Long id ) {
		this.repository.deleteById(id);
	}
	
}
