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
@Table(name = "Customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String first_name;
	
	@Column
	private String last_name;
	
	@Column
	private String business_name;
	
	@Column
	private String RUC;
	
	@Column
	private String email;
	
	@Column
	private String address;
	
	@Column
	private String phone;
	
	@Column
	private String document_number;
	
	@Column
	private Date created_at;
	
	@Column
	private Date updated_at;
	
	@Column
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "document_type_id", referencedColumnName = "id")
	private DocumentType documenttype;
	
}
