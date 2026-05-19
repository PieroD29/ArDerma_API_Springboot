package com.arderma.Arderma_System_API.ModelDTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class UserDTO {

	Long id;
	
	String first_name;
	
	String last_name;
	
	String email;
	
	String document_number;
	
	Date birth_date;
	
	String phone;
	
	boolean gender;
	
	String address;
	
	String password;
	
	Long document_type_id;
	
	Long role_id;
	
}
