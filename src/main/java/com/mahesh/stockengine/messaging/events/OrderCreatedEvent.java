package com.mahesh.stockengine.messaging.events;


import com.mahesh.stockengine.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record OrderCreatedEvent(
        UUID orderId,
        OrderStatus status,
        String clientId,
        String symbol,
        String side,
        String type,
        long quantity,
        BigDecimal price,
        Instant createdAt
) {}

