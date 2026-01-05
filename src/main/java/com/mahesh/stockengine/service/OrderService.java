package com.mahesh.stockengine.service;

import com.mahesh.stockengine.domain.Order;
import com.mahesh.stockengine.enums.OrderStatus;
import com.mahesh.stockengine.mappers.OrderRequestDTO;
import com.mahesh.stockengine.persistence.entity.OrderEntity;
import com.mahesh.stockengine.persistence.mapper.OrderEntityMapper;
import com.mahesh.stockengine.persistence.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@AllArgsConstructor
@Service
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private final OrderEntityMapper mapper;

    public UUID createNew(OrderRequestDTO dto) {
        Order order = Order.createNew(dto);
        OrderEntity entity = mapper.toEntity(order);
        return orderRepository.save(entity).getOrderId();
    }
}
