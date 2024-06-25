package com.example.demo.model.countries;

import com.example.demo.model.countries.currency.Currency;
import com.example.demo.model.countries.currency.Euro;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@ToString(callSuper = true)
@Component("FR")
public class France extends Country {
    private France(Euro currency) {
        super(currency , "0.20");
    }
}

//private France(@Value("${EUR}") String currency, @Value("${FRANCE.TAX}") String tax) {

//@Value("${FRANCE.NAME}") String name,