package com.arderma.Arderma_System_API.ModelDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DocumentTypeDTO {

	Long id;
	
	String document_type;
	
	boolean status;
	
}
