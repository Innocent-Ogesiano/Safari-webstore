package com.example.safariwebstore008.services;

import com.example.safariwebstore008.models.User;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    User createDispatchRider (User dispatchRider);
}
