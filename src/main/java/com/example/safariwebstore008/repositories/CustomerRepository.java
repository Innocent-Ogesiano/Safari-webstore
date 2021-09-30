package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findCustomerByEmail(String email);
}
