package com.arderma.Arderma_System_API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arderma.Arderma_System_API.Model.Receipt_Type;

@Repository
public interface Receipt_TypeRepository extends JpaRepository<Receipt_Type, Long> {

}
