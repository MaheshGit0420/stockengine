package com.mahesh.stockengine.controller;


import com.mahesh.stockengine.mappers.OrderRequestDTO;
import com.mahesh.stockengine.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public UUID postOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO) {

        System.out.println(orderRequestDTO.type());
        return orderService.createNew(orderRequestDTO);
        // return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
