package com.example.safariwebstore008.enums;

public enum Roles {
    ANNONYMOUS("annonymous"),CUSTOMER("customer"), ADMIN("admin"),DISPATCH_RIDER("dispatch rider");
   private final  String role ;

    Roles(String role) {
        this.role=role;
    }
}
