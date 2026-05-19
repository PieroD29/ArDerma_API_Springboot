package com.arderma.Arderma_System_API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arderma.Arderma_System_API.Model.ProcessStatus;

@Repository
public interface ProcessStatusRepository extends JpaRepository<ProcessStatus, Long> {

}
