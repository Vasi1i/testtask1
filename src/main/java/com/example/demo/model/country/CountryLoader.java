package com.example.demo.model.country;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Configuration
@ConfigurationProperties(prefix="country")
public class CountryLoader {
    private List<String> code;
    private List<String> name;
    private List<String> tax;
    private List<String> currency;

    @Bean
    public Map<String, Country> initCountries() {
        Map<String, Country> countries = new HashMap<>();
        for (int i = 0; i < code.size(); i++) {
            countries.put(code.get(i), new Country(code.get(i), name.get(i), new BigDecimal(tax.get(i)), currency.get(i)));
        }
        return countries;
    }
}