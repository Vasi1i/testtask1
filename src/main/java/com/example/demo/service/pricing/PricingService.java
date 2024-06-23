package com.example.demo.service.pricing;

import com.example.demo.controller.request.PriceRequest;
import com.example.demo.exeption.InvalidInputException;
import com.example.demo.model.Coupon;
import com.example.demo.model.Product;
import com.example.demo.model.tax.Country;
import com.example.demo.repository.CouponRepository;
import com.example.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class PricingService {
    private final ProductRepository productRepository;
    private final CouponRepository couponRepository;

    public BigDecimal calculatePrice(PriceRequest priceRequest) throws InvalidInputException {
        Product product = productRepository.findById(priceRequest.getProduct())
                .orElseThrow(() -> new InvalidInputException("Product not found"));
        BigDecimal price = product.getPrice();
        if (priceRequest.getCouponCode() != null) {
            Coupon coupon = couponRepository.findByCode(priceRequest.getCouponCode())
                    .orElseThrow(() -> new InvalidInputException("Invalid coupon code"));
            if (coupon.isPercentage()) {
                price = price.subtract(price.multiply(coupon.getDiscountValue().divide(new BigDecimal("100"))));
            } else {
                price = price.subtract(coupon.getDiscountValue());
            }
        }
        return price.add(price.multiply(getCountry(priceRequest.getTaxNumber()).getTax().taxRate()));
    }

    private Country getCountry(String taxNumber) {
        return Country.valueOf(taxNumber.substring(0, 2).toUpperCase());
    }
}