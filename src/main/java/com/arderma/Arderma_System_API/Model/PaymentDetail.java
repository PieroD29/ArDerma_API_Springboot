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
@Table(name = "Payment_Detail")
public class PaymentDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String operation_number;
	
	@Column
	private Date payment_date;
	
	@Column
	private float collected_amount;
	
	@Column
	private String dermablock_units;
	
	@Column
	private String observations;
	
	@Column
	private Date created_at;
	
	@Column
	private Date updated_at;
	
	@Column
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "sale_id", referencedColumnName = "id")
	private Sale sale;
	
	@ManyToOne
	@JoinColumn(name = "payment_method_id", referencedColumnName = "id")
	private PaymentMethod paymentMethod;

}
