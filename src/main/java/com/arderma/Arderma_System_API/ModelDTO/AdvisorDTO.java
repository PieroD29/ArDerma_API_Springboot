package com.arderma.Arderma_System_API.ModelDTO;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AdvisorDTO {
	
	Long id;
	
	String code;
	
	Date created_at;
	
	Date updated_at;
	
	boolean status;
	
	Long user_id;
	
	Long headquarters;

}
