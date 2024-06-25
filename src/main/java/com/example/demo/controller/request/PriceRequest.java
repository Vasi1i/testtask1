package com.example.demo.controller.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
@NoArgsConstructor
public class PriceRequest {
    private final String TAX_NUMBER_VALIDATOR = "^(?i)(DE\\d{9}|IT\\d{11}|GR\\d{9}|FR[A-Z]{2}\\d{9})$";
    private final String COUPON_CODE_VALIDATOR = "^[pdPD]([1-9]|[1-9][0-9]|[1][0][0])$";
    @NotNull
    private Long product;
    @Pattern(regexp = TAX_NUMBER_VALIDATOR)
    private String taxNumber;
    @Pattern(regexp = COUPON_CODE_VALIDATOR)
    private String couponCode;
}
