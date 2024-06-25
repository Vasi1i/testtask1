package com.example.demo.model.countries;

import com.example.demo.model.countries.currency.Euro;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@ToString(callSuper = true)
@Component("GR")
public class Greece extends Country {
    protected Greece(Euro currency) {
        super(currency, "0.24");
    }
}
//@Value("${GREECE.NAME}") String name,