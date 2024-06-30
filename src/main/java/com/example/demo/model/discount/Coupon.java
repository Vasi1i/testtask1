package com.example.demo.model.discount;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@Table(name = "coupon")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Coupon implements Discount{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private BigDecimal discount;
    private Boolean percentage;

    @Override
    public String getDiscountCode() {
        return code;
    }

    @Override
    public BigDecimal getDiscountValue() {
        return discount;
    }

    @Override
    public boolean isDiscountPercentage() {
        return percentage;
    }
}
