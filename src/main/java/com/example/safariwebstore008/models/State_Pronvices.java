package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
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
public class State_Pronvices extends BaseClass {


    @Null(message = "state field is empty")
    private  String stateName;

    @OneToMany
    private List<Cities>listOfCitiesInAState;
    @OneToOne(mappedBy = "coverage")
    private DispatchRider dispatchRider;
}
