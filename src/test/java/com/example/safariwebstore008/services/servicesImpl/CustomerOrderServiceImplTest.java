package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.SafariWebstore008Application;
import com.example.safariwebstore008.dto.CheckoutDto;
import com.example.safariwebstore008.enums.*;
import com.example.safariwebstore008.models.Cart;
import com.example.safariwebstore008.models.CustomerOrder;
import com.example.safariwebstore008.models.ShippingAddress;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.repositories.CustomerOrderRepository;
import com.example.safariwebstore008.repositories.ShippingRepository;
import com.example.safariwebstore008.repositories.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SafariWebstore008Application.class)
class CustomerOrderServiceImplTest {
    @Autowired
    private  CustomerOrderRepository repository;
    @Autowired
    UserRepository userModelRepository;
    @Mock
    private UserRepository userRepository;

@Mock
private CustomerOrderRepository customerOrderRepository;
@Mock
private ShippingRepository shippingRepository;
    @InjectMocks
    private CustomerOrderServicesImpl customerOrderService;
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
        customerOrder.setUserModel(user);
//        customerOrder.setCart(cart);
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setEmail(checkoutDto.getEmail());
        shippingAddress.setUserModel(user);
        customerOrder.setShippingAddress(shippingAddress);
        CustomerOrder customerOrder1 = new CustomerOrder();
        customerOrder1.setShippingAddress(shippingAddress);
        when(shippingRepository.save(shippingAddress)).thenReturn(shippingAddress);
        when(customerOrderRepository.save(customerOrder)).thenReturn(customerOrder);



       CustomerOrder customerOrder2= customerOrderService.createACustomerOrder(checkoutDto);
        Assertions.assertThat(customerOrder.getShippingAddress().getEmail()).isEqualTo(checkoutDto.getEmail());
    }
    @Test
    void customerOrderHistoryTest(){


        String email= "nono@gmail.com";
        User user= new User();
        user.setEmail(email);
        user.setPassword("1234");
        user.setFirstName("ben");
        user.setLastName("tom");
        user.setRoles(Roles.CUSTOMER);
        user.setGender(Gender.MALE);
        userModelRepository.save(user);
        int pageNo=0;
        int pageSize=2;
        String sortBy= "deliveryDate";
        Pageable pageable = PageRequest.of(pageNo,pageSize,Sort.by(sortBy).descending());
        CustomerOrder customerOrder1= new CustomerOrder();
        customerOrder1.setUserModel(user);
        repository.save(customerOrder1);
        CustomerOrder customerOrder2= new CustomerOrder();
        customerOrder2.setUserModel(user);
        repository.save(customerOrder2);
        CustomerOrder customerOrder3= new CustomerOrder();
        customerOrder3.setUserModel(user);
        repository.save(customerOrder3);

        Page<CustomerOrder> customerOrderPage= repository.findAllByUserModel(user,pageable);
        List<CustomerOrder>customerOrderList =customerOrderPage.toList();
        assertEquals(2,customerOrderList.size());

    }

    @Test
    public void findCustomerOrderTest() {

        CustomerOrder customerOrder = new CustomerOrder();
        customerOrder.setId(1L);
        customerOrder.setDeliveryFee(500.0);
        when(customerOrderRepository.findById(1L)).thenReturn(java.util.Optional.of(customerOrder));
        assertEquals(customerOrder, customerOrderService.findParticularCustomerOrder(1L));
    }
}