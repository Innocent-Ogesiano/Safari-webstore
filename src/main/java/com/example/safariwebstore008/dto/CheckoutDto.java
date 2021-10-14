package com.example.safariwebstore008.dto;

import com.example.safariwebstore008.models.Cart;
import lombok.Data;

@Data
public class CheckoutDto {
  private String firstName;
  private String lastName;
  private String email;
  private String province;
  private String address;
  private  String city;
  private String phoneNumber;
  private String deliveryMethod;
  private Double deliveryFee;
  private Cart cart;
  private Double totalOrderAmount;
}
