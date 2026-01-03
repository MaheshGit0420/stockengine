package com.mahesh.stockengine.domain;


import com.mahesh.stockengine.enums.OrderSide;
import com.mahesh.stockengine.enums.OrderStatus;
import com.mahesh.stockengine.enums.OrderType;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Getter
public class Order {

    private final UUID orderId;
    private final String clientId;
    private final String symbol;
    private final OrderSide side;
    private final OrderType type;
    private final long quantity;
    private final BigDecimal price;
    private final OrderStatus status;
    private final Instant createdAt;

    public Order(
            UUID orderId,
            String clientId,
            String symbol,
            OrderSide side,
            OrderType type,
            long quantity,
            BigDecimal price,
            OrderStatus status,
            Instant createdAt
    ) {
        // business invariants here
        this.orderId = Objects.requireNonNull(orderId);
        this.clientId = Objects.requireNonNull(clientId);
        this.symbol = Objects.requireNonNull(symbol);
        this.side = side;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.status = status;
        this.createdAt = createdAt;
    }
}