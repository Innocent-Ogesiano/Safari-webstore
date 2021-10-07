package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities_lga_table")
@Entity
public class Cities extends BaseClass {
    @NotNull(message = "city-name field is empty")
    private  String cityName;

}
