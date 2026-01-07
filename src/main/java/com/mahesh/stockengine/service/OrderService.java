package com.mahesh.stockengine.service;

import com.mahesh.stockengine.domain.Order;
import com.mahesh.stockengine.mappers.OrderEventMapper;
import com.mahesh.stockengine.mappers.OrderRequestDTO;
import com.mahesh.stockengine.messaging.events.OrderCreatedEvent;
import com.mahesh.stockengine.entity.OrderEntity;
import com.mahesh.stockengine.mappers.OrderEntityMapper;
import com.mahesh.stockengine.repository.OrderRepository;
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
    private final OrderEventMapper orderEventMapper;

    public UUID createNew(OrderRequestDTO dto) {
        Order order = Order.createNew(dto);
        OrderCreatedEvent event = orderEventMapper.toCreatedEvent(order);
        OrderEntity entity = mapper.toEntity(order);
        return orderRepository.save(entity).getOrderId();
    }
}
