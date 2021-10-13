package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.models.CustomerOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Long> {
    CustomerOrder findCustomerOrderById(Long id);
}
