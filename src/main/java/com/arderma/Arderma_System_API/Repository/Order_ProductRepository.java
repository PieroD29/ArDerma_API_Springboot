package com.arderma.Arderma_System_API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arderma.Arderma_System_API.Model.Order_Product;

@Repository
public interface Order_ProductRepository extends JpaRepository<Order_Product, Long> {

}
