package com.mahesh.stockengine.controller;


import com.mahesh.stockengine.dto.OrderRequestDTO;
import com.mahesh.stockengine.messaging.producer.OrderEventProducer;
import com.mahesh.stockengine.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderEventProducer orderEventProducer;

    public OrderController(OrderService orderService, OrderEventProducer orderEventProducer) {
        this.orderService = orderService;
        this.orderEventProducer = orderEventProducer;
    }

    @PostMapping
    public void postOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO) {

        orderService.createNew(orderRequestDTO);
    }
}
