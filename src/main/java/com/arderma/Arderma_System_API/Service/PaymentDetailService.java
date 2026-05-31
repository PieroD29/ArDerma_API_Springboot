package com.arderma.Arderma_System_API.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arderma.Arderma_System_API.Model.PaymentDetail;
import com.arderma.Arderma_System_API.Model.PaymentMethod;
import com.arderma.Arderma_System_API.Model.Sale;
import com.arderma.Arderma_System_API.ModelDTO.PaymentDetailDTO;
import com.arderma.Arderma_System_API.Repository.PaymentDetailRepository;

@Service
public class PaymentDetailService {

	private final PaymentDetailRepository repository;
	
	public PaymentDetailService( PaymentDetailRepository repository ) {
		this.repository = repository;
	}
	
	public List<PaymentDetailDTO> getPaymentDetails(){
		return repository.findAll()
				.stream()
				.map( pd -> new PaymentDetailDTO(pd.getId(),
						pd.getOperation_number(),
						pd.getPayment_date(),
						pd.getCollected_amount(),
						pd.getDermablock_units(),
						pd.getObservations(),
						pd.getCreated_at(),
						pd.getUpdated_at(),
						pd.isStatus(),
						pd.getSale().getId(),
						pd.getPaymentMethod().getId()) )
				.collect( Collectors.toList() );
	}
	
	public PaymentDetailDTO savePaymentDetail( PaymentDetailDTO dto ) {
		PaymentDetail paymentdetail = new PaymentDetail();
		Sale sale = new Sale();
		PaymentMethod paymentmethod = new PaymentMethod();
		
		if ( dto.getId()!= null ) paymentdetail.setId( dto.getId() );
		
		paymentdetail.setOperation_number( dto.getOperation_number() );
		paymentdetail.setPayment_date( dto.getPayment_date() );
		paymentdetail.setCollected_amount( dto.getCollected_amount() );
		paymentdetail.setDermablock_units( dto.getDermablock_units() );
		paymentdetail.setObservations( dto.getObservation() );
		paymentdetail.setCreated_at( dto.getCreated_at() );
		paymentdetail.setUpdated_at( dto.getUpdated_at() );
		paymentdetail.setStatus( dto.isStatus() );
		
		sale.setId( dto.getSales_id() );
		paymentmethod.setId( dto.getPayment_method_id() );
		
		paymentdetail.setSale(sale);
		paymentdetail.setPaymentMethod(paymentmethod);
		
		PaymentDetail svPd = repository.save(paymentdetail);
		
		return new PaymentDetailDTO(svPd.getId(),
				svPd.getOperation_number(),
				svPd.getPayment_date(),
				svPd.getCollected_amount(),
				svPd.getDermablock_units(),
				svPd.getObservations(),
				svPd.getCreated_at(),
				svPd.getUpdated_at(),
				svPd.isStatus(),
				svPd.getSale().getId(),
				svPd.getPaymentMethod().getId()
				);
	}
	
	public void deletePaymentDetail( Long id ) {
		this.repository.deleteById(id);
	}
	
}
