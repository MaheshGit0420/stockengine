package com.mahesh.stockengine.mappers;

import com.mahesh.stockengine.enums.OrderSide;
import com.mahesh.stockengine.enums.OrderType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

public record OrderRequestDTO(

        @NotBlank
        String clientId,

        @NotBlank
        String symbol,

        @NotNull
        OrderSide side,

        @NotNull
        OrderType type,

        @Positive
        long quantity,

        @DecimalMin(value = "0.0", inclusive = false)
        BigDecimal price
) {}