package com.arderma.Arderma_System_API.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arderma.Arderma_System_API.Model.Advisor;
import com.arderma.Arderma_System_API.Model.Customer;
import com.arderma.Arderma_System_API.Model.Laboratory;
import com.arderma.Arderma_System_API.Model.Orders;
import com.arderma.Arderma_System_API.Model.ProcessStatus;
import com.arderma.Arderma_System_API.ModelDTO.OrdersDTO;
import com.arderma.Arderma_System_API.Repository.OrdersRepository;

@Service
public class OrdersService {

	private final OrdersRepository repository;
	
	public OrdersService( OrdersRepository repository ) {
		this.repository = repository;
	}
	
	public List<OrdersDTO> getOrders(){
		return repository.findAll()
				.stream()
				.map( o -> new OrdersDTO(o.getId(),
						o.getSubtotal(),
						o.getShipping(),
						o.getTotal(),
						o.getCreated_at(),
						o.getUpdated_at(),
						o.isStatus(),
						o.getLaboratory().getId(),
						o.getAdvisor().getId(),
						o.getCustomer().getId(),
						o.getProcessstatus().getId()) )
				.collect( Collectors.toList() );
	}
	
	public OrdersDTO saveOrder( OrdersDTO dto ) {
		Orders order = new Orders();
		Laboratory laboratory = new Laboratory();
		Advisor advisor = new Advisor();
		Customer customer = new Customer();
		ProcessStatus processstatus = new ProcessStatus();
		
		if ( dto.getId() != null ) order.setId( dto.getId() );
		
		order.setSubtotal( dto.getSubtotal() );
		order.setShipping( dto.getShipping() );
		order.setTotal( dto.getTotal() );
		order.setCreated_at( dto.getCreated_at() );
		order.setUpdated_at( dto.getUpdated_at() );
		order.setStatus( dto.isStatus() );
		
		laboratory.setId( dto.getLaboratory_id() );
		advisor.setId( dto.getAdvisor_id() );
		customer.setId( dto.getCustomer_id() );
		processstatus.setId( dto.getProcessstatus_id() );
		
		order.setLaboratory(laboratory);
		order.setAdvisor(advisor);
		order.setCustomer(customer);
		order.setProcessstatus(processstatus);
		
		Orders svOrder = repository.save(order);
		
		return new OrdersDTO(svOrder.getId(),
				svOrder.getSubtotal(),
				svOrder.getShipping(),
				svOrder.getTotal(),
				svOrder.getCreated_at(),
				svOrder.getUpdated_at(),
				svOrder.isStatus(),
				svOrder.getLaboratory().getId(),
				svOrder.getAdvisor().getId(),
				svOrder.getCustomer().getId(),
				svOrder.getProcessstatus().getId()
				);
	}
	
	public void deleteOrder( Long id ) {
		this.repository.deleteById(id);
	}
	
}
