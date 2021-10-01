package com.example.safariwebstore008.services.servicesImpl;

import com.example.safariwebstore008.dto.UpdateCustomerDto;
import com.example.safariwebstore008.models.Customer;
import com.example.safariwebstore008.repositories.CustomerRepository;
import com.example.safariwebstore008.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.Optional;
@Service
public class CustomerServiceImpl implements CustomerServices {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer updateCustomer(UpdateCustomerDto updateCustomerDto,String email) throws AccountNotFoundException {
       Customer customer = customerRepository.findCustomerByEmail(email);
       if(customer!=null){
           customer.setFirstName(updateCustomerDto.getFirstName());
           customer.setFirstName(updateCustomerDto.getLastName());
           return customerRepository.save(customer);
       }
        else{
            throw new AccountNotFoundException("User account not found");
       }
    }
}
