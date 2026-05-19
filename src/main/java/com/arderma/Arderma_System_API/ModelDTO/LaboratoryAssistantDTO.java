package com.arderma.Arderma_System_API.ModelDTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LaboratoryAssistantDTO {

	Long id;
	
	Date created_at;
	
	Date updated_at;
	
	boolean status;
	
	Long user_id;
	
	Long laboratory_id;
	
}
