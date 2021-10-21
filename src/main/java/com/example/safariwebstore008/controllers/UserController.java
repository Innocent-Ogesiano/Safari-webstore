package com.example.safariwebstore008.controllers;

import com.example.safariwebstore008.configurations.JwtTokenUtil;
import com.example.safariwebstore008.dto.UpdatePasswordDto;
import com.example.safariwebstore008.models.User;
import com.example.safariwebstore008.services.CustomerOrderServices;
import com.example.safariwebstore008.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import com.example.safariwebstore008.dto.CheckoutDto;
import com.example.safariwebstore008.models.CustomerOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/customer")
public class UserController {
    UriComponentsBuilder uriComponentsBuilder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserServices userServices;
    private CustomerOrderServices customerOrderService;

    @Autowired
    public UserController(UserServices userServices, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil,CustomerOrderServices customerOrderService) {
        this.userServices = userServices;
        this.jwtTokenUtil = jwtTokenUtil;
        this.authenticationManager = authenticationManager;
        this.customerOrderService = customerOrderService;

    }

    @PutMapping("/updatePassword/{token}")
    private ResponseEntity<User> updatePassword(@RequestBody UpdatePasswordDto updatePasswordDto, @PathVariable("token") String token) throws Exception {
        String email = jwtTokenUtil.getUserEmailFromToken(token);
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, updatePasswordDto.oldPassword));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        User user = userServices.updatePassword(updatePasswordDto, email);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

  
    @PostMapping("/checkout")
    private ResponseEntity<?> createACustomerOrder(@RequestBody CheckoutDto checkoutDto){
       CustomerOrder customerOrder=customerOrderService.createACustomerOrder(checkoutDto);
       if(customerOrder!=null){
       return new ResponseEntity<>(customerOrder,HttpStatus.CREATED);
       }else{
           return new ResponseEntity<>("User not allowed",HttpStatus.FORBIDDEN);
       }
    }
    
    @GetMapping("/orderHistory")
    private ResponseEntity<?> viewOrderHistory(@RequestParam(defaultValue = "0")int pageNo,
                                               @RequestParam(defaultValue = "5") int pageSize,
                                               @RequestParam(defaultValue = "deliveryDate") String sortByDate, HttpServletRequest request){

         String requestTokenHeader = request.getHeader("Authorization");
         String jwtToken = requestTokenHeader.substring(7);
         String userEmail= jwtTokenUtil.getUserEmailFromToken(jwtToken);

         List<CustomerOrder> customerOrderPage= customerOrderService.viewCustomerOrderHistory(userEmail,pageNo,pageSize,sortByDate);

         return new ResponseEntity<>(customerOrderPage,HttpStatus.ACCEPTED);

    }
}
