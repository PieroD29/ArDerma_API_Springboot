package com.arderma.Arderma_System_API.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "monthly_advisor_summary")
public class MonthlyAdvisorSummary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private int month;
	
	@Column
	private int year;
	
	@Column
	private float total_sales;
	
	@Column
	private float applied_scale;
	
	@Column
	private float minimum_goal;
	
	@Column
	private float extra_sales;
	
	@Column
	private float commission;
	
	@Column
	private float event_bonus;
	
	@Column
	private float dermablock_bonus;
	
	@Column
	private float total_to_deposit;
	
	@Column
	private Date closing_date;
	
	@Column
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "advisor_id", referencedColumnName = "id")
	private Advisor advisor;

}
