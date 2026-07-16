package com.mahesh.stockengine.matchingengine;


import com.mahesh.stockengine.domain.Order;
import com.mahesh.stockengine.mappers.OrderEventMapper;
import com.mahesh.stockengine.messaging.events.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/*
@Component
public class MatchingEngineConsumer {

    private OrderEventMapper orderEventMapper;
    private OrderMatcher orderMatcher;

    MatchingEngineConsumer(OrderMatcher orderMatcher, OrderEventMapper orderEventMapper) {

        this.orderEventMapper = orderEventMapper;
        this.orderMatcher = orderMatcher;
    }

    @KafkaListener(topics = "order-events", groupId = "stock-engine")
    public void consume(OrderCreatedEvent event) {

        System.out.println("Printing from matching consumer: " + event.orderId());

        // Order order = orderEventMapper.toOrderFromEvent(event);
        // System.out.println("After reconstruction of order " + order);

        orderMatcher.process(event);

    }
}
*/