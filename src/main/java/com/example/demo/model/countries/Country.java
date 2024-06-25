package com.example.demo.model.countries;


import com.example.demo.model.countries.currency.Currency;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Map;

@ToString
@Getter
public abstract class Country {
    private final String name;
    private final Currency currency;
    private final BigDecimal tax;
    protected Country(Currency currency, String tax) {
        this.name = this.getClass().getSimpleName();
        this.currency = currency;
        this.tax = new BigDecimal(tax);
    }
}

//    private static final Map<String, Currency> currencies;
//        this.currency = Currency.valueOf(currency.toUpperCase());
