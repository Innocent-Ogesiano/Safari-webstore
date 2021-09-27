package com.example.safariwebstore008.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities_lga_table")
@Entity
public class Cities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Null(message = "city-name field is empty")
    private  String cityName;
}
