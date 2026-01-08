package com.mahesh.stockengine.service;

import com.mahesh.stockengine.domain.Order;
import com.mahesh.stockengine.mappers.OrderEventMapper;
import com.mahesh.stockengine.mappers.OrderRequestDTO;
import com.mahesh.stockengine.messaging.OrderEventProducer;
import com.mahesh.stockengine.messaging.events.OrderCreatedEvent;
import com.mahesh.stockengine.entity.OrderEntity;
import com.mahesh.stockengine.mappers.OrderEntityMapper;
import com.mahesh.stockengine.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;



@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderEntityMapper orderEntityMapper;
    private final OrderEventMapper orderEventMapper;
    private final OrderEventProducer orderEventProducer;

    public OrderService(OrderRepository orderRepository, OrderEntityMapper orderEntityMapper, OrderEventMapper orderEventMapper, OrderEventProducer orderEventProducer) {

        this.orderRepository = orderRepository;
        this.orderEntityMapper = orderEntityMapper;
        this.orderEventMapper = orderEventMapper;
        this.orderEventProducer = orderEventProducer;
    }

    public UUID createNew(OrderRequestDTO dto) {
        Order order = Order.createNew(dto);
        OrderCreatedEvent event = orderEventMapper.toCreatedEvent(order);
        orderEventProducer.publish(event);
        OrderEntity entity = orderEntityMapper.toEntity(order);
        return orderRepository.save(entity).getOrderId();
    }
}
