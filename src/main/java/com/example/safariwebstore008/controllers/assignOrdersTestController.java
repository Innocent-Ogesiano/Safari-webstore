package com.example.safariwebstore008.controllers;

import com.example.safariwebstore008.models.CustomerOrder;
import com.example.safariwebstore008.models.ShippingAddress;
import com.example.safariwebstore008.repositories.CustomerOrderRepository;
import com.example.safariwebstore008.repositories.ShippingAdressRepository;
import com.example.safariwebstore008.services.servicesImpl.AssignOrderToDispatchRider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.Date;

@RestController
public class assignOrdersTestController {
        @Autowired
        AssignOrderToDispatchRider assignOrderToDispatchRider;
    @Autowired
    CustomerOrderRepository customerOrderRepository;
    @Autowired
    ShippingAdressRepository shippingAddressRepository;
    @GetMapping("/assignorder")
    public void assignOrderToDispatchRider() throws MessagingException {
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setEmail("jummyhanna@gmail.com");
        shippingAddress.setFirstName("olawale");
        shippingAddress.setLastName("deji");
        shippingAddress.setPhoneNumber("080263095");
        shippingAddress.setCityName("ikorodu");
        shippingAddress.setRegionName("A");
        shippingAddress.setHomeAdddress("10 adebowale street");
        shippingAddressRepository.save(shippingAddress);
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setShippingAddress(shippingAddress);
        customerOrder.setDeliveryDate(new Date());
        customerOrderRepository.save(customerOrder);
        assignOrderToDispatchRider.assignOrderToDispatchRider(customerOrder);
        System.out.println(shippingAddress.toString());
    }
}
