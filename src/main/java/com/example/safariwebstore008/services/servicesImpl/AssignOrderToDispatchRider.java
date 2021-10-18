package com.example.safariwebstore008.services.servicesImpl;


import com.example.safariwebstore008.dto.MailDto;
import com.example.safariwebstore008.enums.OrderAssigStatus;
import com.example.safariwebstore008.exceptions.DispatchRiderNotFoundException;
import com.example.safariwebstore008.models.*;
import com.example.safariwebstore008.repositories.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.Optional;

import static com.example.safariwebstore008.enums.Roles.*;

@Service
@Data
public class AssignOrderToDispatchRider {
    @Autowired
    CustomerOrderRepository customerOrderRepository;
    @Autowired
    RegionServiceImpl regionService;
    @Autowired
    AssignOrderServiceImp assignOrderServiceImp;
    @Autowired
    MailServiceImpl mailService;

    public void  assignOrderToDispatchRider(CustomerOrder customerOrder) throws MessagingException {
      ShippingAddress shippingAddress = customerOrder.getShippingAddress();
        String regionName =  shippingAddress.getRegionName();
        System.out.println(regionName);
        ServiceRegion regionAssigned =regionService.findServiceRegionByName(regionName);
        User dispatchRider = regionAssigned.getUser();
        AssignOrders assignOrders = new AssignOrders();
        assignOrders.setOrders(customerOrder);
        assignOrders.setUser(dispatchRider);
        customerOrder.setStatus(OrderAssigStatus.ASSIGNED);
    customerOrderRepository.save(customerOrder);
        assignOrderServiceImp.saveAssignOrders(assignOrders);
       String dispatchRiderEmail = dispatchRider.getEmail();
      String  deliveryDate = String.valueOf(customerOrder.getDeliveryDate());
      String shippingInfo = shippingAddress.toString() +
              "\n"+ deliveryDate;
        MailDto assignOrderNotification = new MailDto(dispatchRiderEmail,"New Assign order",shippingInfo);
      mailService.sendMail(assignOrderNotification);

    }

}
