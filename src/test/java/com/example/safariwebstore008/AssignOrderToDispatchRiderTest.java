package com.example.safariwebstore008;

import com.example.safariwebstore008.enums.DeliveryStatus;
import com.example.safariwebstore008.enums.Gender;
import com.example.safariwebstore008.enums.OrderAssigStatus;
import com.example.safariwebstore008.enums.Roles;
import com.example.safariwebstore008.models.*;
import com.example.safariwebstore008.repositories.AssignedOrderRepository;
import com.example.safariwebstore008.repositories.CustomerOrderRepository;
import com.example.safariwebstore008.repositories.UserRepository;
import com.example.safariwebstore008.services.servicesImpl.AssignOrderToDispatchRider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AssignOrderToDispatchRiderTest {



    @Mock
    private CustomerOrderRepository customerOrderRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private AssignedOrderRepository assignedOrderRepository;

    @InjectMocks
    private AssignOrderToDispatchRider assignOrder;



    @Test
    public void assignOrderToDispatchRiderTest() throws Exception {

        Date date = new Date(1980, 05, 01);
        final User customer = new User("Kim","Woods", date, "kim@gmail.com", Gender.MALE, Roles.CUSTOMER
                ,"kim12",true,null);

        //@NotNull(message = "first-name field is empty")
        //    private String firstName;
        //
        //    @NotNull(message = "last-name field is empty")
        //    private  String lastName;
        //
        //    @NotNull(message = "email field is empty")
        //   @Email(message = "email is not properly formatted")
        //    private  String email;
        //
        //    @NotNull(message = "phone number field is empty")
        //    private  String phoneNumber;
        //    @NotNull(message = "address field is empty")
        //    private String address;
        //    @ManyToOne
        //    private StatePronvices state;
        //    @ManyToOne
        //   private User userModel;
        //    private String RegionName;
        //    private String CityName;

        Date deliveryDate= new Date(2021,9,20);
        DeliveryStatus deliveryStatus= DeliveryStatus.PENDING;
        Double sum= 3000.00;
        Double deliveryFee= 500.00;
        ShippingAddress shippingAddress= new ShippingAddress("Kim","Woods","kim@gmail.com","090124590", "5,Olaniyi street",new StatePronvices("Lagos",List.of(new Cities("Apapa"),new Cities("Egbeda"))),customer,"Lagos","Egbeda");
        OrderAssigStatus orderAssigStatus = OrderAssigStatus.UNASSIGNED;

       String regionName= shippingAddress.getRegionName();

        CustomerOrder customerOrder= new CustomerOrder(1L,deliveryDate,deliveryStatus,sum,deliveryFee,shippingAddress, orderAssigStatus);

        User dispatchRider= new User("Tim","Woods", date, "tim@gmail.com", Gender.MALE, Roles.DISPATCH_RIDER
                ,"tim12",true, regionName);

        AssignOrders assignOrders= new AssignOrders();
        assignOrders.setOrders(customerOrder);
        assignOrders.setUser(dispatchRider);

        when(customerOrderRepository.findCustomerOrderById(customerOrder.getId())).thenReturn(customerOrder);
        when(userRepository.findByRolesAndDispatchRiderLocation(Roles.DISPATCH_RIDER,regionName)).thenReturn(Optional.of(dispatchRider));
        when(assignedOrderRepository.save(assignOrders)).thenReturn(assignOrders);


        AssignOrders assignOrders1= assignOrder.assignOrderToDispatchRider(customerOrder.getId());

        assertNotNull(assignOrders1);
        assertEquals(assignOrders1.getUser(), dispatchRider);


    }
}
