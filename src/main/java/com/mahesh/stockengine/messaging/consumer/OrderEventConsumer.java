package com.mahesh.stockengine.messaging.consumer;


import com.mahesh.stockengine.messaging.events.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderEventConsumer {

    // @KafkaListener(topics = "order-events", groupId = "stock-engine")
    public void consumeEvent(OrderCreatedEvent order) {
        log.info("Received order: {}", order);
        System.out.println("Received order: " + order);
    }
}
