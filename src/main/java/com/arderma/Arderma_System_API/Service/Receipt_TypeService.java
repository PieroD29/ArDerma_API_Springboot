package com.arderma.Arderma_System_API.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arderma.Arderma_System_API.Model.Receipt_Type;
import com.arderma.Arderma_System_API.ModelDTO.Receipt_TypeDTO;
import com.arderma.Arderma_System_API.Repository.Receipt_TypeRepository;

@Service
public class Receipt_TypeService {

	private final Receipt_TypeRepository repository;
	
	public Receipt_TypeService( Receipt_TypeRepository repository ) {
		this.repository = repository;
	}
	
	public List<Receipt_TypeDTO> getReceipt_Type(){
		return repository.findAll()
				.stream()
				.map( rt -> new Receipt_TypeDTO(rt.getId(),
						rt.getReceipt_type(),
						rt.isStatus()) )
				.collect( Collectors.toList() );
	}
	
	public Receipt_TypeDTO saveReceipt_Type( Receipt_TypeDTO dto ) {
		Receipt_Type receipttype = new Receipt_Type();
		
		if ( dto.getId() != null ) receipttype.setId( dto.getId() );
		
		receipttype.setReceipt_type( dto.getReceipt_type() );
		receipttype.setStatus( dto.isStatus() );
		
		Receipt_Type svRt = repository.save(receipttype);
		
		return new Receipt_TypeDTO(svRt.getId(),
				svRt.getReceipt_type(),
				svRt.isStatus()
				);
	}
	
	public void deleteReceipt_Type( Long id ) {
		this.repository.deleteById(id);
	}
	
}
