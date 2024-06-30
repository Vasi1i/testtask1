package com.example.demo.model.discount;

import java.math.BigDecimal;

public interface Discount {
    String getDiscountCode();
    BigDecimal getDiscountValue();
    boolean isDiscountPercentage();
}
