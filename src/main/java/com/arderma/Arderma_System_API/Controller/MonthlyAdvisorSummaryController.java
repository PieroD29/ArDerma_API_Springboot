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

import com.arderma.Arderma_System_API.ModelDTO.MonthlyAdvisorSummaryDTO;
import com.arderma.Arderma_System_API.Service.MonthlyAdvisorSummaryService;

@RestController
@RequestMapping("/api")
public class MonthlyAdvisorSummaryController {

	private final MonthlyAdvisorSummaryService service;
	
	public MonthlyAdvisorSummaryController( MonthlyAdvisorSummaryService service ) {
		this.service = service;
	}
	
	@GetMapping("/monthlysummary")
	public List<MonthlyAdvisorSummaryDTO> getMonthlySummary(){
		return service.getMothlySummary();
	}
	
	@PostMapping("/monthlysummary")
	public MonthlyAdvisorSummaryDTO createMonthlySummary( @RequestBody MonthlyAdvisorSummaryDTO dto ) {
		return service.saveMonthlySummary(dto);
	}
	
	@PutMapping("/monthlysummary")
	public MonthlyAdvisorSummaryDTO updateMonthlySummary( @RequestBody MonthlyAdvisorSummaryDTO dto ) {
		return service.saveMonthlySummary(dto);
	}
	
	@DeleteMapping("/monthlysummary/{id}")
	public void deleteMonthlySummary( @PathVariable Long id ) {
		this.service.deleteMonthlySummary(id);
	}
	
}
