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
@Entity
public class Colors extends BaseClass {
    @NotNull(message = "color field is empty")
    private  String color;
}
