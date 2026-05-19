package com.arderma.Arderma_System_API.ModelDTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {

	Long id;
	
	String first_name;
	
	String last_name;
	
	String business_name;
	
	String RUC;
	
	String email;
	
	String address;
	
	String phone;
	
	String document_number;
	
	Date created_at;
	
	Date updated_at;
	
	boolean status;
	
	Long document_type_id;
	
}
