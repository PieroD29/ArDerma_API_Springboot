package com.arderma.Arderma_System_API.ModelDTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class PermissionDTO {

	Long id;
	
	String action;
	
	Date created_at;
	
	Date updated_at;
	
	boolean status;
	
}
