package com.example.safariwebstore008.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCartItemDto {
    int ItemQuanty;
    Long cartItemId;
}
