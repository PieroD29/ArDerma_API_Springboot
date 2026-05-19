package com.arderma.Arderma_System_API.ModelDTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ProductDTO {

	Long id;
	
	String name;
	
	float price;
	
	String code;
	
	int stock;
	
	String description;
	
	String image;
	
	boolean is_customizable;
	
	Date created_at;
	
	Date updated_at;
	
	boolean status;
	
}
