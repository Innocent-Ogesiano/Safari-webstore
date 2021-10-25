package com.example.safariwebstore008.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductPage {
    private int pageNumber =0;
    private int pageSize = 10;
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    private String sortBy = "id";
}
