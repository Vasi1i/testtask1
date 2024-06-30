package com.example.demo.model.discount;

import jakarta.persistence.Entity;

import java.math.BigDecimal;


public interface Discount {
    String getDiscountCode();
    BigDecimal getDiscountValue();
    boolean isDiscountPercentage();
}
