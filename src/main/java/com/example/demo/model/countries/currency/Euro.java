package com.example.demo.model.countries.currency;

import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
public class Euro implements Currency {
    @Override
    public String getCode() {
        return "EUR";
    }
}