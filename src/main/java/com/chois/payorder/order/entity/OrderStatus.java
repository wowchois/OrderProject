package com.chois.payorder.order.entity;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum OrderStatus {
    REQUESTED("01"),
    ACCEPTED("02"),
    SHIPPING("03"),
    COMPLETED("04"),
    REJECTED("00");

    private final String statCode;

    public String getStatCode(){
        return statCode;
    }
}
