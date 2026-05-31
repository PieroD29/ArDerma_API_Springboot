package com.arderma.Arderma_System_API.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arderma.Arderma_System_API.Model.ProcessStatus;
import com.arderma.Arderma_System_API.ModelDTO.ProcessStatusDTO;
import com.arderma.Arderma_System_API.Repository.ProcessStatusRepository;

@Service
public class ProcessStatusService {

	private final ProcessStatusRepository repository;
	
	public ProcessStatusService( ProcessStatusRepository repository ) {
		this.repository = repository;
	}
	
	public List<ProcessStatusDTO> getProcessStatus(){
		return repository.findAll()
				.stream()
				.map( ps -> new ProcessStatusDTO(ps.getId(),
						ps.getProcess_status(),
						ps.isStatus()) )
				.collect( Collectors.toList() );
	}
	
	public ProcessStatusDTO saveProcessStatus( ProcessStatusDTO dto ) {
		ProcessStatus processstatus = new ProcessStatus();
		
		if ( dto.getId() != null ) processstatus.setId( dto.getId() );
		
		processstatus.setProcess_status( dto.getProcess_status() );
		processstatus.setStatus( dto.isStatus() );
		
		ProcessStatus svPs = repository.save(processstatus);
		
		return new ProcessStatusDTO(svPs.getId(),
				svPs.getProcess_status(),
				svPs.isStatus());
	}
	
	public void deleteProcessStatus( Long id ) {
		this.repository.deleteById(id);
	}
	
}
