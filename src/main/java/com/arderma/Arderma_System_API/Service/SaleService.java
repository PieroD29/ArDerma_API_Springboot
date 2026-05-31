package com.arderma.Arderma_System_API.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arderma.Arderma_System_API.Model.Orders;
import com.arderma.Arderma_System_API.Model.Receipt_Type;
import com.arderma.Arderma_System_API.Model.Sale;
import com.arderma.Arderma_System_API.ModelDTO.SaleDTO;
import com.arderma.Arderma_System_API.Repository.SaleRepository;

@Service
public class SaleService {

	private final SaleRepository repository;
	
	public SaleService( SaleRepository repository ) {
		this.repository = repository;
	}
	
	public List<SaleDTO> getSales(){
		return repository.findAll()
				.stream()
				.map( s -> new SaleDTO( s.getId(),
						s.getReceipt_sale(),
						s.getBilled_amount(),
						s.getPayment_conditions(),
						s.getCreated_at(),
						s.getUpdated_at(),
						s.isStatus(),
						s.getReceipttype().getId(),
						s.getOrders().getId() ) )
				.collect( Collectors.toList() );
	}
	
	public SaleDTO saveSale( SaleDTO dto ) {
		
		Sale sale = new Sale();
		Receipt_Type receipttype = new Receipt_Type();
		Orders order = new Orders();
		
		if ( dto.getId() != null ) sale.setId( dto.getId() );
		
		sale.setReceipt_sale( dto.getReceipt_sale() );
		sale.setBilled_amount( dto.getBilled_amount() );
		sale.setPayment_conditions( dto.getPayment_conditions() );
		sale.setCreated_at( dto.getCreated_at() );
		sale.setUpdated_at( dto.getUpdated_at() );
		sale.setStatus( dto.isStatus() );
		
		receipttype.setId( dto.getReceipt_type_id() );
		order.setId( dto.getOrder_id() );
		
		sale.setReceipttype(receipttype);
		sale.setOrders(order);
		
		Sale svSale = repository.save(sale);
		
		return new SaleDTO( svSale.getId(),
				svSale.getReceipt_sale(),
				svSale.getBilled_amount(),
				svSale.getPayment_conditions(),
				svSale.getCreated_at(),
				svSale.getUpdated_at(),
				svSale.isStatus(),
				svSale.getReceipttype().getId(),
				svSale.getOrders().getId()
				);
	}
	
	public void deleteUser( Long id ) {
		this.repository.deleteById(id);
	}
	
}
