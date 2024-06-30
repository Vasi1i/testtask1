package com.example.demo.controller.dto.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@ToString
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PriceRequest {
    @NotNull
    @Digits(integer = 12, fraction = 0)
    private Long product;
    @NotNull
    @Pattern(regexp = "^(?i)(DE\\d{9}|IT\\d{11}|GR\\d{9}|FR[A-Z]{2}\\d{9})$")
    private String taxNumber;
    @Pattern(regexp = "(?i)^(p(?:[1-9]\\d?|100)|d(?:[1-9]\\d{0,5}))$")
    private String couponCode;
}