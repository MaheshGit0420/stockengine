package com.mahesh.stockengine.messaging.events;


import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record OrderCreatedEvent(
        UUID orderId,
        String clientId,
        String symbol,
        String side,
        String type,
        long quantity,
        BigDecimal price,
        Instant createdAt
) {}

