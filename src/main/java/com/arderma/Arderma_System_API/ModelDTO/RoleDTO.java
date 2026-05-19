package com.arderma.Arderma_System_API.ModelDTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class RoleDTO {

	Long id;
	
	String name;
	
	String description;
	
	Date created_at;
	
	Date updated_at;
	
	boolean status;
	
}
