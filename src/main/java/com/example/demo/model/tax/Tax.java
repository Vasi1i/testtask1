package com.example.demo.model.tax;

import java.math.BigDecimal;
import java.util.Objects;

public record Tax(Currency currency, BigDecimal taxRate) {
        public Tax {
        Objects.requireNonNull(currency, "Currency must not be null");
        Objects.requireNonNull(taxRate, "Tax rate must not be null");
    }
}