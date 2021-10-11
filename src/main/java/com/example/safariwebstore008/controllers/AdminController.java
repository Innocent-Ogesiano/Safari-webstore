package com.example.safariwebstore008.controllers;

import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/admin/")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "registerDispatchRider", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody User dispatchRider) throws Exception {
        return ResponseEntity.ok(adminService.createDispatchRider(dispatchRider));
    }
}
