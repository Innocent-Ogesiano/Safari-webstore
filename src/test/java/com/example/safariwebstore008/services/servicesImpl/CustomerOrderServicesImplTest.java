package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.SafariWebstore008Application;
import com.example.safariwebstore008.enums.DeliveryMethod;
import com.example.safariwebstore008.enums.DeliveryStatus;
import com.example.safariwebstore008.enums.OrderAssigStatus;
import com.example.safariwebstore008.models.CustomerOrder;
import com.example.safariwebstore008.repositories.CustomerOrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SafariWebstore008Application.class)
class CustomerOrderServicesImplTest {

    @Autowired
    CustomerOrderServicesImpl customerOrderServices;

    @Autowired
    CustomerOrderRepository orderRepository;

    @Test
    public void getOrdersByDispatchAssignmentStatusTest(){
        CustomerOrder assignedOrder = new CustomerOrder();
        assignedOrder.setStatus(OrderAssigStatus.ASSIGNED);
        assignedOrder.setTotalOrderAmount(10000d);
        assignedOrder.setDeliveryStatus(DeliveryStatus.PENDING);
        assignedOrder.setDeliveryMethod(DeliveryMethod.DOOR_DELIVERY);
        assignedOrder.setDeliveryDate(new Date(28-10-2021));
        assignedOrder.setDeliveryFee(500d);
        orderRepository.save(assignedOrder);

        CustomerOrder unassignedOrder = new CustomerOrder();
        unassignedOrder.setStatus(OrderAssigStatus.UNASSIGNED);
        unassignedOrder.setTotalOrderAmount(10000d);
        unassignedOrder.setDeliveryStatus(DeliveryStatus.PENDING);
        unassignedOrder.setDeliveryMethod(DeliveryMethod.DOOR_DELIVERY);
        unassignedOrder.setDeliveryDate(new Date(29-10-2021));
        unassignedOrder.setDeliveryFee(700d);
        orderRepository.save(unassignedOrder);

        int pageNo = 0;
        int pageSize = 2;
        String sortBy = "status";

        ResponseEntity<Map<String, Object>> getAssignedOrder = customerOrderServices.getAllAssignedOrder(pageNo, pageSize, sortBy);
        ResponseEntity<Map<String, Object>> getUnassignedOrder = customerOrderServices.getAllUnassignedOrder(pageNo, pageSize, sortBy);

        assertEquals(200, getAssignedOrder.getStatusCodeValue());
        assertEquals(200, getUnassignedOrder.getStatusCodeValue());
    }
}