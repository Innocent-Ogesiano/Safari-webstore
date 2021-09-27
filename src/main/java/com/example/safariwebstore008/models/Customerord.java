package com.example.safariwebstore008.models;

import com.example.safariwebstore008.enums.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customerord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Date deliveryDate;
    private DeliveryStatus deliveryStatus;
    @OneToMany
    private List<OrdDetails> eachOrderItem;
    @CreationTimestamp
    private LocalDateTime createDate;
    @UpdateTimestamp
    private LocalDateTime updateDate;
    private Double sum;
    private Double deliveryFee;
    @OneToOne
    private DeliveryMethod deliveryMethod;




}
