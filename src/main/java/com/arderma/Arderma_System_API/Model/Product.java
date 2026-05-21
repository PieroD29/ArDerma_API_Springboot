package com.arderma.Arderma_System_API.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private float price;
	
	@Column
	private String code;
	
	@Column
	private int stock;
	
	@Column
	private String description;
	
	@Column
	private String image;
	
	@Column
	private boolean is_customizable;
	
	@Column
	private Date created_at;
	
	@Column
	private Date updated_at;
	
	@Column
	private boolean status;
	
}
