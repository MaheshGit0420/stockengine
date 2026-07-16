package com.mahesh.stockengine.mappers;

import com.mahesh.stockengine.domain.Order;
import com.mahesh.stockengine.enums.OrderSide;
import com.mahesh.stockengine.enums.OrderType;
import com.mahesh.stockengine.messaging.events.OrderCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public final class OrderEventMapper {

    private OrderEventMapper() {}

    public OrderCreatedEvent toCreatedEvent(Order order) {
        return new OrderCreatedEvent(
                order.getOrderId(),
                order.getStatus(),
                order.getClientId(),
                order.getSymbol(),
                order.getSide().name(),
                order.getType().name(),
                order.getQuantity(),
                order.getPrice(),
                order.getCreatedAt()
        );
    }

//    public Order toOrderFromEvent(OrderCreatedEvent event) {
//
//        return new Order(
//                event.clientId(),
//                event.symbol(),
//                OrderSide.valueOf(event.side()),
//                OrderType.valueOf(event.type()),
//                event.quantity(),
//                event.price(),
//                event.orderId(),
//                event.status(),
//                event.createdAt()
//        );
//    }
}
