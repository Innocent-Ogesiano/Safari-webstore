package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.enums.DeliveryStatus;
import com.example.safariwebstore008.models.CustomerOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
    Page<CustomerOrder> findByDeliveryStatus(DeliveryStatus deliveryStatus, Pageable pageable);
@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Long> {

    CustomerOrder findCustomerOrderById(Long id);

}
