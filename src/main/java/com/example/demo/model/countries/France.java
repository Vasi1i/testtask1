package com.example.demo.model.countries;

import com.example.demo.model.countries.currency.Euro;
import lombok.ToString;
import org.springframework.stereotype.Component;

@ToString(callSuper = true)
@Component("FR")
public class France extends Country {
    private France(Euro currency) {
        super(currency , "0.20");
    }
}