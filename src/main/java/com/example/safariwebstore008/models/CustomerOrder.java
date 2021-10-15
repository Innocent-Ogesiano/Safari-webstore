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
    private ShippingAddress shippingAddress;
    @Enumerated(EnumType.STRING)
    private OrderAssigStatus status;
    @Enumerated(EnumType.STRING)
    private DeliveryMethod deliveryMethod;
    @ManyToOne
    private Cart cart;
    private Double totalOrderAmount;
    @ManyToOne
    private User user;

    public CustomerOrder( Long id,Date deliveryDate, DeliveryStatus deliveryStatus,Double deliveryFee,Double totalOrderAmount, ShippingAddress shippingAddress, OrderAssigStatus status) {
        super(id);
        this.deliveryDate = deliveryDate;
        this.deliveryStatus = deliveryStatus;
        this.deliveryFee = deliveryFee;
        this.shippingAddress = shippingAddress;
        this.status = status;
        this.totalOrderAmount= totalOrderAmount;
    }


}
