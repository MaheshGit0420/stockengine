package com.mahesh.stockengine.model;


import com.mahesh.stockengine.enums.OrderSide;
import com.mahesh.stockengine.enums.OrderStatus;
import com.mahesh.stockengine.enums.OrderType;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Entity
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
}