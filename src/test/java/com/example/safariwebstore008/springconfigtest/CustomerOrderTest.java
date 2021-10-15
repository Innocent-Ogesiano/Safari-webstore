package com.example.safariwebstore008.springconfigtest;

import com.example.safariwebstore008.models.CustomerOrder;
import com.example.safariwebstore008.repositories.CustomerOrderRepository;
import com.example.safariwebstore008.services.servicesImpl.CustomerOrderServicesImpl;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

public class CustomerOrderTest {

    @Autowired
    private CustomerOrderRepository customerOrderRepository = mock(CustomerOrderRepository.class);
    private CustomerOrderServicesImpl customerOrderServices = new CustomerOrderServicesImpl(customerOrderRepository);

    @Test


    void testReturnPagedOrders() {



        Page<CustomerOrder> tasks = Mockito.mock(Page.class);
        Mockito.when(this.customerOrderRepository.findAll(org.mockito.Matchers.isA(Pageable.class))).thenReturn(tasks);


    }






}
