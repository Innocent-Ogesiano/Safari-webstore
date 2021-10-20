package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.models.AssignOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignedOrderRepository extends JpaRepository<AssignOrders,Long> {
}
