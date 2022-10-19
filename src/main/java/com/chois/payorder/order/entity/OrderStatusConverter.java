package com.chois.payorder.order.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.EnumSet;
import java.util.NoSuchElementException;

@Converter
public class OrderStatusConverter implements AttributeConverter<OrderStatus,String> {
    @Override
    public String convertToDatabaseColumn(OrderStatus attribute) {
        return attribute.getStatCode();
    }

    @Override
    public OrderStatus convertToEntityAttribute(String dbData) {
        return EnumSet.allOf(OrderStatus.class).stream()
                .filter(e -> e.getStatCode().equals(dbData))
                .findAny()
                .orElseThrow(()-> new NoSuchElementException());
    }
}
