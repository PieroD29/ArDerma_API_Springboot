package com.arderma.Arderma_System_API.ModelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ProcessStatusDTO {

	Long id;
	
	String process_status;
	
	boolean status;
	
}
