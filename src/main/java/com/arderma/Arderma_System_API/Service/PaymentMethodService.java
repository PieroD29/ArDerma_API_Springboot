package com.arderma.Arderma_System_API.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arderma.Arderma_System_API.Model.PaymentMethod;
import com.arderma.Arderma_System_API.ModelDTO.PaymentMethodDTO;
import com.arderma.Arderma_System_API.Repository.PaymentMethodRepository;

@Service
public class PaymentMethodService {

	private final PaymentMethodRepository repository;
	
	public PaymentMethodService( PaymentMethodRepository repository ) {
		this.repository = repository;
	}
	
	public List<PaymentMethodDTO> getPaymentMehtods(){
		return repository.findAll()
				.stream()
				.map( pm -> new PaymentMethodDTO(pm.getId(),
						pm.getPayment_method(),
						pm.isStatus()) )
				.collect( Collectors.toList() );
	}
	
	public PaymentMethodDTO savePaymentMethod( PaymentMethodDTO dto ) {
		PaymentMethod paymentmethod = new PaymentMethod();
		
		if ( dto.getId() != null ) paymentmethod.setId( dto.getId() );
		
		paymentmethod.setPayment_method( dto.getPayment_method() );
		paymentmethod.setStatus( dto.isStatus() );
		
		PaymentMethod svPm = repository.save(paymentmethod);
		
		return new PaymentMethodDTO(svPm.getId(),
				svPm.getPayment_method(),
				svPm.isStatus()
				);
	}
	
	public void deletePaymentMethod( Long id ) {
		this.repository.deleteById(id);
	}
	
}
