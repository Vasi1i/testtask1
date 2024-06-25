package com.example.demo.model.countries;

import com.example.demo.model.countries.currency.Euro;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@ToString(callSuper = true)
@Component("DE")
public class Germany extends Country {
    protected Germany(Euro currency) {
        super(currency, "0.19");
    }
}

//protected Germany(@Value("${EUR}") String currency, @Value("${GERMANY.TAX}") String tax) {
//@Value("${GERMANY.NAME}") String name,