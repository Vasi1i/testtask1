package com.example.demo.controller.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static com.example.demo.controller.request.Constants.*;

@Getter
@ToString
@SuperBuilder
@NoArgsConstructor
public abstract class BaseRequest {
    @NotNull
    private Long product;
    @Pattern(regexp = TAX_NUMBER_REGEX)
    private String taxNumber;
    @Pattern(regexp = COUPON_CODE_REGEX)
    private String couponCode;
}
