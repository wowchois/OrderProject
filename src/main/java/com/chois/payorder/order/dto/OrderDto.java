package com.chois.payorder.order.dto;

import com.chois.payorder.order.entity.Order;
import lombok.Getter;

@Getter
public class OrderDto {

    private long orderUserId;
    private long menuId;

    public OrderDto(long orderUserId, long menuId){
        this.orderUserId = orderUserId;
        this.menuId = menuId;
    }

    public Order toEntity(){
        return new Order(orderUserId,menuId);
    }
}
