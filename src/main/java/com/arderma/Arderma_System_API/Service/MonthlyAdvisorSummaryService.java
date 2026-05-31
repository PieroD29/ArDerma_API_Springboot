package com.arderma.Arderma_System_API.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arderma.Arderma_System_API.Model.Advisor;
import com.arderma.Arderma_System_API.Model.MonthlyAdvisorSummary;
import com.arderma.Arderma_System_API.ModelDTO.MonthlyAdvisorSummaryDTO;
import com.arderma.Arderma_System_API.Repository.MonthlyAdvisorSummaryRepository;

@Service
public class MonthlyAdvisorSummaryService {

	private final MonthlyAdvisorSummaryRepository repository;
	
	public MonthlyAdvisorSummaryService( MonthlyAdvisorSummaryRepository repository ) {
		this.repository = repository;
	}
	
	public List<MonthlyAdvisorSummaryDTO> getMothlySummary(){
		return repository.findAll()
				.stream()
				.map( m -> new MonthlyAdvisorSummaryDTO(m.getId(),
						m.getMonth(),
						m.getYear(),
						m.getTotal_sales(),
						m.getApplied_scale(),
						m.getMinimum_goal(),
						m.getExtra_sales(),
						m.getCommission(),
						m.getEvent_bonus(),
						m.getDermablock_bonus(),
						m.getTotal_to_deposit(),
						m.getClosing_date(),
						m.isStatus(),
						m.getAdvisor().getId()) )
				.collect( Collectors.toList() );
	}
	
	public MonthlyAdvisorSummaryDTO saveMonthlySummary( MonthlyAdvisorSummaryDTO dto ) {
		MonthlyAdvisorSummary ms = new MonthlyAdvisorSummary();
		Advisor advisor = new Advisor();
		
		if ( dto.getId() != null ) ms.setId( dto.getId() );
		
		ms.setMonth( dto.getMonth() );
		ms.setYear( dto.getYear() );
		ms.setTotal_sales( dto.getTotal_sales() );
		ms.setApplied_scale( dto.getApplied_scale() );
		ms.setMinimum_goal( dto.getMinimum_goal() );
		ms.setExtra_sales( dto.getExtra_sales() );
		ms.setCommission( dto.getCommission() );
		ms.setEvent_bonus( dto.getEvent_bonus() );
		ms.setDermablock_bonus( dto.getDermablock_bonus() );
		ms.setTotal_to_deposit( dto.getTotal_to_deposit() );
		ms.setClosing_date( dto.getClosing_date() );
		ms.setStatus( dto.isStatus() );
		
		advisor.setId( dto.getAdvisor_id() );
		
		ms.setAdvisor(advisor);
		
		MonthlyAdvisorSummary sv = repository.save(ms);
		
		return new MonthlyAdvisorSummaryDTO(sv.getId(),
				sv.getMonth(),
				sv.getYear(),
				sv.getTotal_sales(),
				sv.getApplied_scale(),
				sv.getMinimum_goal(),
				sv.getExtra_sales(),
				sv.getCommission(),
				sv.getEvent_bonus(),
				sv.getDermablock_bonus(),
				sv.getTotal_to_deposit(),
				sv.getClosing_date(),
				sv.isStatus(),
				sv.getAdvisor().getId()
				);
	}
	
	public void deleteMonthlySummary( Long id ) {
		this.repository.deleteById(id);
	}
	
}
