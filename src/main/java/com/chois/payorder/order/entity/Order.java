package com.chois.payorder.order.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private long orderUserId;

    @Column(nullable = false)
    private long menuId;

    @CreationTimestamp
    private LocalDateTime createdDate;

    @Builder
    public Order(long orderUserId, long menuId){
        this.orderUserId = orderUserId;
        this.menuId = menuId;
    }

}
