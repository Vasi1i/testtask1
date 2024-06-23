package com.example.demo.model.tax;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

import static com.example.demo.model.tax.Currency.*;
import static com.example.demo.model.tax.Constants.*;

@Getter
@AllArgsConstructor
public enum Country {
    DE(new Tax(EUR, new BigDecimal(DE_TAX_RATE))),
    IT(new Tax(EUR, new BigDecimal(IT_TAX_RATE))),
    GR(new Tax(EUR, new BigDecimal(GR_TAX_RATE))),
    FR(new Tax(EUR, new BigDecimal(FR_TAX_RATE)));
    private final Tax tax;
}