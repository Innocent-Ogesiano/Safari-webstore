package com.example.safariwebstore008.models;
import com.example.safariwebstore008.common.BaseClass;
import com.example.safariwebstore008.enums.DeliveryMethod;
import com.example.safariwebstore008.enums.DeliveryStatus;
import com.example.safariwebstore008.enums.OrderAssigStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerOrder extends BaseClass {
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date deliveryDate;
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
    private Double deliveryFee;
    @ManyToOne
    private ShippingAddress shippingAddress;
    @Enumerated(EnumType.STRING)
    private OrderAssigStatus status;
    @Enumerated(EnumType.STRING)
    private DeliveryMethod deliveryMethod;
    private Double totalOrderAmount;
    @ManyToOne
    @JsonIgnore
    private User userModel;

}
