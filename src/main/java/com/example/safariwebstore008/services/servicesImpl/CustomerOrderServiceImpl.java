package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.CheckoutDto;
import com.example.safariwebstore008.enums.DeliveryMethod;
import com.example.safariwebstore008.enums.DeliveryStatus;
import com.example.safariwebstore008.enums.OrderAssigStatus;
import com.example.safariwebstore008.models.CustomerOrder;
import com.example.safariwebstore008.models.ShipingAddress;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.CustomerOrderRepository;
import com.example.safariwebstore008.repositories.ShippingRepository;
import com.example.safariwebstore008.services.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private ShippingRepository shippingRepository;

    @Override
    public CustomerOrder createACustomerOrder(CheckoutDto checkoutDto) {
        CustomerOrder customerOrder = new CustomerOrder();
        ShipingAddress shipingAddress= new ShipingAddress();
        User user = checkoutDto.getCart().getUserModel();
        customerOrder.setDeliveryFee(checkoutDto.getDeliveryFee());
        customerOrder.setCart(checkoutDto.getCart());
        customerOrder.setStatus(OrderAssigStatus.UNASSIGNED);
        customerOrder.setDeliveryStatus(DeliveryStatus.PENDING);
        customerOrder.setCreateDate(LocalDateTime.now());
        customerOrder.setUserModel(user);
        customerOrder.setTotalOrderAmount(checkoutDto.getTotalOrderAmount());
        customerOrder.setDeliveryMethod(DeliveryMethod.DOOR_DELIVERY);
        shipingAddress.setEmail(checkoutDto.getEmail());
        shipingAddress.setAddress(checkoutDto.getAddress());
        shipingAddress.setCityName(checkoutDto.getCity());
        shipingAddress.setUserModel(user);
        shipingAddress.setRegionName(checkoutDto.getProvince());
        shipingAddress.setUpdateDate(LocalDateTime.now());
        shipingAddress.setFirstName(checkoutDto.getFirstName());
        shipingAddress.setLastName(checkoutDto.getLastName());
        shipingAddress.setPhoneNumber(checkoutDto.getPhoneNumber());
        shippingRepository.save(shipingAddress);
        customerOrder.setShippingAddress(shipingAddress);
        return customerOrderRepository.save(customerOrder);
    }
}
