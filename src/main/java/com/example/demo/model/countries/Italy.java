package com.example.demo.model.countries;

import com.example.demo.model.countries.currency.Euro;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@ToString(callSuper = true)
@Component("IT")
public class Italy extends Country {
    private Italy(Euro currency) {
        super(currency, "0.22");
    }
}

//protected Italy(@Value("${EUR}") String currency, @Value("${ITALY.TAX}") String tax) {
//@Value("${ITALY.NAME}") String name,