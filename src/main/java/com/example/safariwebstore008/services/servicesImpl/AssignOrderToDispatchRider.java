package com.example.safariwebstore008.services.servicesImpl;


import com.example.safariwebstore008.enums.OrderAssigStatus;
import com.example.safariwebstore008.exceptions.DispatchRiderNotFoundException;
import com.example.safariwebstore008.models.*;
import com.example.safariwebstore008.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.safariwebstore008.enums.Roles.*;

@Service
public class AssignOrderToDispatchRider {

    private CustomerOrderRepository customerOrderRepository;
    private AssignedOrderRepository assignOrderRepository;
    private UserRepository userRepository;

    @Autowired
    public void setAssignOrderToDispatchRider(AssignedOrderRepository assignedOrderRepository, CustomerOrderRepository customerOrderRepository,
                                      UserRepository userRepository){
        this.customerOrderRepository = customerOrderRepository;
        this.assignOrderRepository = assignedOrderRepository;
        this.userRepository = userRepository;
    }



    public AssignOrders assignOrderToDispatchRider(Long customerOrderId) throws Exception {
      CustomerOrder customerOrder= customerOrderRepository.findCustomerOrderById(customerOrderId);

      String regionName= customerOrder.getShippingAddress().getRegionName();

        Optional<User> dispatchRider = userRepository.findByRolesAndDispatchRiderLocation
              (DISPATCH_RIDER, regionName);
      AssignOrders assignOrders = new AssignOrders();
      assignOrders.setOrders(customerOrder);

      if(dispatchRider.isEmpty()){
          throw new DispatchRiderNotFoundException("Cannot find dispatch rider");
      }
      assignOrders.setUser(dispatchRider.get());
      customerOrder.setStatus(OrderAssigStatus.ASSIGNED);

        return assignOrderRepository.save(assignOrders);

    }


}
