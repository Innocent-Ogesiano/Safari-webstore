package com.example.safariwebstore008.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.MessageFormat;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerOrderNotFoundException extends RuntimeException{
    public CustomerOrderNotFoundException(final Long id){
        super(MessageFormat.format("Could not find cart with id: {0}", id));
    }
}

