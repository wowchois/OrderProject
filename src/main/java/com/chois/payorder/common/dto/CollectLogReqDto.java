package com.chois.payorder.common.dto;

import lombok.Data;

@Data
public class CollectLogReqDto {
    private long userId;
    private long menuId;
    private int price;

    public CollectLogReqDto(long userId, long menuId, int price){
        this.userId = userId;
        this.menuId = menuId;
        this.price = price;
    }
}
