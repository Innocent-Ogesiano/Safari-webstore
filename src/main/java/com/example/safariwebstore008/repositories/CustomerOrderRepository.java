package com.example.safariwebstore008.repositories;

import com.example.safariwebstore008.enums.OrderAssigStatus;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.enums.DeliveryStatus;
import com.example.safariwebstore008.models.CustomerOrder;
import com.example.safariwebstore008.services.CustomerOrderServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Long> {
    Page<CustomerOrder> findByDeliveryStatus(DeliveryStatus deliveryStatus,Pageable pageable);
    Page<CustomerOrder> findAllByUserModel(User userModel, Pageable pageable);
    CustomerOrder findCustomerOrderById(Long id);
    Page<CustomerOrder> findByStatus(OrderAssigStatus status, Pageable pageable);

}
