package com.arderma.Arderma_System_API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arderma.Arderma_System_API.Model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
