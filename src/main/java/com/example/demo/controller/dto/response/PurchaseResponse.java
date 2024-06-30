package com.example.demo.controller.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
public class PurchaseResponse extends PriceResponse {
    private boolean paymentSuccessful;
    public PurchaseResponse(PriceResponse priceResponse, boolean paymentSuccessful) {
        super(priceResponse.getProductId(), priceResponse.getProductName(), priceResponse.getBasePrice(), priceResponse.getDiscountValue(), priceResponse.getTax(), priceResponse.getFinalPrice(), priceResponse.getCurrency(), priceResponse.getCountryCode(), priceResponse.getTaxNumber(), priceResponse.getDiscountCode());
        this.paymentSuccessful = paymentSuccessful;
    }
}