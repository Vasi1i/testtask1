package com.example.demo.model.countries;

import com.example.demo.model.countries.currency.Euro;
import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString(callSuper = true)
@Component("DE")
public class Germany extends Country {
    protected Germany(Euro currency) {
        super(currency, "0.19");
    }
}