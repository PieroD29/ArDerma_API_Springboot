package com.arderma.Arderma_System_API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arderma.Arderma_System_API.Model.Order_Discount;

@Repository
public interface Order_DiscountRepository extends JpaRepository<Order_Discount, Long> {

}
