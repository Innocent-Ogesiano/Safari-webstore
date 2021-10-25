package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.models.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long> {

}
