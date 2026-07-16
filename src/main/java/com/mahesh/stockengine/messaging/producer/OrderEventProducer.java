package com.mahesh.stockengine.messaging.producer;

import com.mahesh.stockengine.dto.OrderRequestDTO;
import com.mahesh.stockengine.messaging.events.OrderCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class OrderEventProducer {

    private final KafkaTemplate<String, OrderRequestDTO> kafkaTemplate;

    public OrderEventProducer(KafkaTemplate<String, OrderRequestDTO> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(OrderRequestDTO orderRequestDTO) {
        kafkaTemplate.send(
                "order-events",
                orderRequestDTO.clientId().toString(),
                orderRequestDTO
        );
    }
}
