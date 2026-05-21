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
@Table(name = "Sale")
public class Sale {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String receipt_sale;
	
	@Column
	private float billed_amount;
	
	@Column
	private String payment_conditions;
	
	@Column
	private Date created_at;
	
	@Column
	private Date updated_at;
	
	@Column
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "receipt_type_id", referencedColumnName = "id")
	private Receipt_Type receipttype;
	
	@ManyToOne
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private Orders orders;
	
	
}
