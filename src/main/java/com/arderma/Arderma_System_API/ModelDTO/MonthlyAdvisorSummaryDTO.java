package com.arderma.Arderma_System_API.ModelDTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class MonthlyAdvisorSummaryDTO {

	Long id;
	
	int month;
	
	int year;
	
	float total_sales;
	
	float applied_scale;
	
	float minimum_goal;
	
	float extra_sales;
	
	float commission;
	
	float event_bonus;
	
	float dermablock_bonus;
	
	float total_to_deposit;
	
	Date closing_date;
	
	boolean status;
	
	Long advisor_id;
	
}
