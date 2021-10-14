package com.example.safariwebstore008.models;

import com.example.safariwebstore008.common.BaseClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class ServiceRegion extends BaseClass {
   private String regionName;
   @OneToMany
   private List<Cities>CitiesWithinARegion;
   @OneToOne
   private User userModel;
}
