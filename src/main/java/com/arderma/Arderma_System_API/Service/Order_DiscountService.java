package com.arderma.Arderma_System_API.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arderma.Arderma_System_API.Model.Discount;
import com.arderma.Arderma_System_API.Model.Order_Discount;
import com.arderma.Arderma_System_API.Model.Orders;
import com.arderma.Arderma_System_API.ModelDTO.Order_DiscountDTO;
import com.arderma.Arderma_System_API.Repository.Order_DiscountRepository;

@Service
public class Order_DiscountService {

	private final Order_DiscountRepository repository;
	
	public Order_DiscountService( Order_DiscountRepository repository ) {
		this.repository = repository;
	}
	
	public List<Order_DiscountDTO> getOrder_Discount(){
		return repository.findAll()
				.stream()
				.map( od -> new Order_DiscountDTO(od.getId(), 
						od.getOrders().getId(), 
						od.getDiscount().getId()) )
				.collect( Collectors.toList() );
	}
	
	public Order_DiscountDTO saveOrder_Discount( Order_DiscountDTO dto ) {
		Order_Discount order_discount = new Order_Discount();
		Orders order = new Orders();
		Discount discount = new Discount();
		
		if ( dto.getId() != null ) order_discount.setId( dto.getId() );
		
		order.setId( dto.getOrder_id() );
		discount.setId( dto.getDiscount_id() );
		
		order_discount.setOrders(order);
		order_discount.setDiscount(discount);
		
		Order_Discount svOd = repository.save(order_discount);
		
		return new Order_DiscountDTO(svOd.getId(),
				svOd.getOrders().getId(),
				svOd.getDiscount().getId()
				);
	}
	
	public void deleteOrder_Discount( Long id ) {
		this.repository.deleteById(id);
	}
	
}
