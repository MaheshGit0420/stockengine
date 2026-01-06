package com.mahesh.stockengine.controller;


import com.mahesh.stockengine.mappers.OrderRequestDTO;
import com.mahesh.stockengine.messaging.OrderEventProducer;
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
    public UUID postOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO) {

        System.out.println(orderRequestDTO.type());
        orderEventProducer.publishOrder("TEST", "Testing topic publishing");
        return orderService.createNew(orderRequestDTO);
        // return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
