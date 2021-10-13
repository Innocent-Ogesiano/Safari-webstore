package com.example.safariwebstore008.models;
import com.example.safariwebstore008.common.BaseClass;
import com.example.safariwebstore008.enums.DeliveryStatus;
import com.example.safariwebstore008.enums.OrderAssignStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerOrder extends BaseClass {
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private Date deliveryDate;
     @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @OneToMany
    private List<OrderDetails> eachOrderItem;

    private Double sum;

    private Double deliveryFee;
    @ManyToOne
    private ShippingAddress shippingAddress;
    @Enumerated(EnumType.STRING)
    private OrderAssignStatus status;



    public CustomerOrder( Long id,Date deliveryDate, DeliveryStatus deliveryStatus, List<OrderDetails> eachOrderItem, Double sum, Double deliveryFee, ShippingAddress shippingAddress, OrderAssignStatus status) {
        super(id);
        this.deliveryDate = deliveryDate;
        this.deliveryStatus = deliveryStatus;
        this.eachOrderItem = eachOrderItem;
        this.sum = sum;
        this.deliveryFee = deliveryFee;
        this.shippingAddress = shippingAddress;
        this.status = status;
    }
}
