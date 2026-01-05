package com.mahesh.stockengine.persistence.mapper;

import com.mahesh.stockengine.domain.Order;
import com.mahesh.stockengine.persistence.entity.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityMapper {

    public OrderEntity toEntity(Order order) {

        OrderEntity entity = new OrderEntity();

        entity.setOrderId(order.getOrderId());
        entity.setClientId(order.getClientId());
        entity.setSymbol(order.getSymbol());
        entity.setSide(order.getSide());
        entity.setType(order.getType());
        entity.setQuantity(order.getQuantity());
        entity.setPrice(order.getPrice());
        entity.setStatus(order.getStatus());
        entity.setCreatedAt(order.getCreatedAt());

        return entity;
    }
}
