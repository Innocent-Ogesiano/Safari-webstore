package com.example.safariwebstore008.models;
import com.example.safariwebstore008.common.BaseClass;
import com.example.safariwebstore008.enums.DeliveryStatus;
import com.example.safariwebstore008.enums.OrderAssigStatus;
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
    private  ShipingAddress shippingAddress;
    private OrderAssigStatus status = OrderAssigStatus.UNASSIGNED;
    @ManyToOne
    private Users user;




}
