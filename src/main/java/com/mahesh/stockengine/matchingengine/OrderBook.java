package com.mahesh.stockengine.matchingengine;

import com.mahesh.stockengine.domain.Order;
import com.mahesh.stockengine.dto.OrderRequestDTO;
import com.mahesh.stockengine.messaging.events.OrderCreatedEvent;
import lombok.Getter;

import java.util.*;

@Getter
public class OrderBook {

    private final String symbol;

    private final NavigableMap<Double, Queue<OrderRequestDTO>> buyBook;
    private final NavigableMap<Double, Queue<OrderRequestDTO>> sellBook;

    public OrderBook(String symbol) {
        this.symbol = symbol;
        this.buyBook = new TreeMap<>(Collections.reverseOrder());
        this.sellBook = new TreeMap<>();
    }


    public void matchOrder(Order order) {


    }


    public void addOrderToBook(String side, OrderCreatedEvent event) {
    }
}
