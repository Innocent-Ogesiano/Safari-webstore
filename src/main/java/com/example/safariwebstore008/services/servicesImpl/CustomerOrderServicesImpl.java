package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.enums.DeliveryStatus;
import com.example.safariwebstore008.models.CustomerOrder;
import com.example.safariwebstore008.repositories.CustomerOrderRepository;
import com.example.safariwebstore008.services.CustomerOrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerOrderServicesImpl implements CustomerOrderServices {

    @Autowired
    private CustomerOrderRepository customerOrderRepository;

    public CustomerOrderServicesImpl(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository =customerOrderRepository;
    }

    @Override
    public List<CustomerOrder> getAllDeliveries(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        Page<CustomerOrder> pagedResult = customerOrderRepository.findAll(pageable);

        return pagedResult.hasContent()?pagedResult.getContent():new ArrayList<>();


    }

    @Override
    public List<CustomerOrder> getAllPendingDeliveries(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        Page<CustomerOrder> pagedResult =  customerOrderRepository.findByDeliveryStatus(DeliveryStatus.PENDING, pageable);

        return pagedResult.hasContent()?pagedResult.getContent():new ArrayList<>();
    }

    @Override
    public List<CustomerOrder> getAllCompletedDeliveries(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<CustomerOrder> pagedResult = customerOrderRepository.findByDeliveryStatus(DeliveryStatus.DELIVERED, pageable);

        return pagedResult.hasContent()?pagedResult.getContent():new ArrayList<>();
    }
}
