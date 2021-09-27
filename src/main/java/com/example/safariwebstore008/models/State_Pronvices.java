package com.example.safariwebstore008.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "state_table")
@Entity
public class State_Pronvices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Null(message = "state field is empty")
    private  String stateName;
    @OneToMany
    private List<Cities>listOfCitiesInAState;
    @OneToOne(mappedBy = "coverage")
    private DispatchRider dispatchRider;
}
