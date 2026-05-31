package com.arderma.Arderma_System_API.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arderma.Arderma_System_API.Model.Laboratory;
import com.arderma.Arderma_System_API.ModelDTO.LaboratoryDTO;
import com.arderma.Arderma_System_API.Repository.LaboratoryRepository;

@Service
public class LaboratoryService {
	
	private final LaboratoryRepository repository;
	
	public LaboratoryService( LaboratoryRepository repository ) {
		this.repository = repository;
	}
	
	public List<LaboratoryDTO> getLaboratories(){
		return repository.findAll()
				.stream()
				.map( l -> new LaboratoryDTO(l.getId(),
						l.getLaboratory_name(),
						l.getAddress(),
						l.getCreated_at(),
						l.getUpdated_at(),
						l.isStatus()) )
				.collect( Collectors.toList() );
	}
	
	public LaboratoryDTO saveLaboratory( LaboratoryDTO dto ) {
		Laboratory lab = new Laboratory();
		
		if ( dto.getId() != null ) lab.setId( dto.getId() );
		
		lab.setLaboratory_name( dto.getLaboratory_name() );
		lab.setAddress( dto.getAddress() );
		lab.setCreated_at( dto.getCreated_at() );
		lab.setUpdated_at( dto.getUpdated_at() );
		lab.setStatus( dto.isStatus() );
		
		Laboratory sv = repository.save(lab);
		
		return new LaboratoryDTO(sv.getId(),
				sv.getLaboratory_name(),
				sv.getAddress(),
				sv.getCreated_at(),
				sv.getUpdated_at(),
				sv.isStatus()
				);
	}
	
	public void deleteLaboratory( Long id ) {
		this.repository.deleteById(id);
	}

}
