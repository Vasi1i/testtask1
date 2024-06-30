package com.example.demo.model.country;

import java.math.BigDecimal;

public record Country(String code, String name, BigDecimal tax, String currency) {
}