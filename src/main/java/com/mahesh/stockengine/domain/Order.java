package com.mahesh.stockengine.domain;


import com.mahesh.stockengine.enums.OrderSide;
import com.mahesh.stockengine.enums.OrderStatus;
import com.mahesh.stockengine.enums.OrderType;
import com.mahesh.stockengine.dto.OrderRequestDTO;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Getter
public class Order {

    private final String clientId;
    private final String symbol;
    private final OrderSide side;
    private final OrderType type;
    private final long quantity;
    private final BigDecimal price;
    private final UUID orderId;
    private final Instant createdAt;
    private OrderStatus status;

    public Order(
            String clientId,
            String symbol,
            OrderSide side,
            OrderType type,
            long quantity,
            BigDecimal price
    ) {
        // business invariants here
        this.orderId = UUID.randomUUID();
        this.clientId = Objects.requireNonNull(clientId);
        this.symbol = Objects.requireNonNull(symbol);
        this.side = side;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.status = OrderStatus.NEW;
        this.createdAt = Instant.now();

    }

    public static Order createNew(OrderRequestDTO dto) {

        return new Order(
                dto.clientId(),
                dto.symbol(),
                dto.side(),
                dto.type(),
                dto.quantity(),
                dto.price()
        );
    }

//    public Order(
//            String clientId,
//            String symbol,
//            OrderSide side,
//            OrderType type,
//            long quantity,
//            BigDecimal price,
//            UUID orderId,
//            OrderStatus status,
//            Instant createdAt
//    ) {
//        this.clientId = clientId;
//        this.symbol = symbol;
//        this.side = side;
//        this.type = type;
//        this.quantity = quantity;
//        this.price = price;
//        this.orderId = orderId;
//        this.status = status;
//        this.createdAt = createdAt;
//    }
}