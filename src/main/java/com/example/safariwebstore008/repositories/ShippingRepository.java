package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.models.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingRepository extends JpaRepository<ShippingAddress,Long> {
}
