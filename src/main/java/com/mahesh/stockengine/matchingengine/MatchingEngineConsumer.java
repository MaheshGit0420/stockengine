package com.mahesh.stockengine.matchingengine;


import com.mahesh.stockengine.domain.Order;
import com.mahesh.stockengine.dto.OrderRequestDTO;
import com.mahesh.stockengine.mappers.OrderEventMapper;
import com.mahesh.stockengine.messaging.events.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.NavigableMap;


@Component
public class MatchingEngineConsumer {

    private OrderMatcher orderMatcher;

    MatchingEngineConsumer(OrderMatcher orderMatcher) {
        this.orderMatcher = orderMatcher;
    }

    @KafkaListener(topics = "order-events", groupId = "stock-engine")
    public void consume(OrderRequestDTO orderRequestDTO) {

        System.out.println("Printing from matching consumer: " + orderRequestDTO.clientId());

        // Order order = orderEventMapper.toOrderFromEvent(event);
        // System.out.println("After reconstruction of order " + order);

        orderMatcher.process(orderRequestDTO);

    }
}
