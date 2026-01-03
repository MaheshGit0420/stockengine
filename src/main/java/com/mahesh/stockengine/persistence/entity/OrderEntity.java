package com.mahesh.stockengine.persistence.entity;

import com.mahesh.stockengine.enums.OrderSide;
import com.mahesh.stockengine.enums.OrderStatus;
import com.mahesh.stockengine.enums.OrderType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderEntity {

    @Id
    private UUID orderId;

    private String clientId;
    private String symbol;

    @Enumerated(EnumType.STRING)
    private OrderSide side;

    @Enumerated(EnumType.STRING)
    private OrderType type;

    private long quantity;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Instant createdAt;
}
