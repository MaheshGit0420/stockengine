package com.mahesh.stockengine.mappers;

import com.mahesh.stockengine.domain.Order;
import com.mahesh.stockengine.messaging.events.OrderCreatedEvent;

public final class OrderEventMapper {

    private OrderEventMapper() {}

    public static OrderCreatedEvent toCreatedEvent(Order order) {
        return new OrderCreatedEvent(
                order.getOrderId(),
                order.getClientId(),
                order.getSymbol(),
                order.getSide().name(),
                order.getType().name(),
                order.getQuantity(),
                order.getPrice(),
                order.getCreatedAt()
        );
    }
}
