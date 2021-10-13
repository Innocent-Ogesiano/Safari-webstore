package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.CheckoutDto;
import com.example.safariwebstore008.enums.DeliveryMethod;
import com.example.safariwebstore008.enums.DeliveryStatus;
import com.example.safariwebstore008.enums.OrderAssigStatus;
import com.example.safariwebstore008.models.Cart;
import com.example.safariwebstore008.models.CustomerOrder;
import com.example.safariwebstore008.models.ShipingAddress;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.CustomerOrderRepository;
import com.example.safariwebstore008.repositories.ShippingRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerOrderServiceImplTest {

@Mock
private CustomerOrderRepository customerOrderRepository;
@Mock
private ShippingRepository shippingRepository;
    @InjectMocks
    private CustomerOrderServiceImpl customerOrderService;
    @Test
    void createACustomerOrder() {
        CheckoutDto checkoutDto= new CheckoutDto();
        checkoutDto.setEmail("richy@gmail.com");
        User user = new User();
        user.setEmail(checkoutDto.getEmail());
        Cart cart = new Cart();
        cart.setUserModel(user);
        checkoutDto.setCart(cart);
        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setDeliveryStatus(DeliveryStatus.PENDING);
        customerOrder.setStatus(OrderAssigStatus.UNASSIGNED);
        customerOrder.setDeliveryMethod(DeliveryMethod.DOOR_DELIVERY);
        customerOrder.setCart(cart);
        ShipingAddress shipingAddress= new ShipingAddress();
        shipingAddress.setEmail(checkoutDto.getEmail());
        shipingAddress.setUserModel(user);
        customerOrder.setShippingAddress(shipingAddress);
        CustomerOrder customerOrder1 = new CustomerOrder();
        customerOrder1.setShippingAddress(shipingAddress);
        when(shippingRepository.save(shipingAddress)).thenReturn(shipingAddress);
        when(customerOrderRepository.save(customerOrder)).thenReturn(customerOrder);



       CustomerOrder customerOrder2= customerOrderService.createACustomerOrder(checkoutDto);
        Assertions.assertThat(customerOrder.getShippingAddress().getEmail()).isEqualTo(checkoutDto.getEmail());
    }
}