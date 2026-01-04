package com.mahesh.stockengine.controller;


import com.mahesh.stockengine.mappers.OrderRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping
    public void postOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO) {

        System.out.println(orderRequestDTO.type());
    }
}
