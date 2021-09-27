package com.example.safariwebstore008.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category_size_table")
public class CategorySize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Null(message = "size field is empty")
    private String size;


    @ManyToOne
    private  ProductCategory category;




}
