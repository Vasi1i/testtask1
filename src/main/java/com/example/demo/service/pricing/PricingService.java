package com.example.demo.service.pricing;

import com.example.demo.controller.request.PriceRequest;
import com.example.demo.exeption.InvalidInputException;
import com.example.demo.model.Coupon;
import com.example.demo.model.Product;
import com.example.demo.model.countries.Country;
import com.example.demo.repository.CouponRepository;
import com.example.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;

@Service
@AllArgsConstructor
public class PricingService {
    private final ProductRepository productRepository;
    private final CouponRepository couponRepository;
    private final Map<String, Country> countries;


    public BigDecimal calculatePrice(PriceRequest request) throws InvalidInputException {
        System.out.println("countries = " + countries);
//        Product product = productRepository.findById(priceRequest.getProduct())
//                .orElseThrow(() -> new InvalidInputException("Product not found"));
        Product product = new Product(1L, "iphone", new BigDecimal("100"));
        BigDecimal price = product.getPrice();
        if (request.getCouponCode() != null) {
            Coupon coupon = new Coupon(111L, "P10", new BigDecimal("6"), true);
//            Coupon coupon = couponRepository.findByCode(priceRequest.getCouponCode())
//                    .orElseThrow(() -> new InvalidInputException("Invalid coupon code"));
            if (coupon.isPercentage()) {
                price = price.subtract(price.multiply(coupon.getDiscountValue().divide(new BigDecimal("100"))));
            } else {
                price = price.subtract(coupon.getDiscountValue());
            }
        }
        System.out.println("getCountry = " + getCountry(request.getTaxNumber()).getCurrency().getCode());
        return price.add(price.multiply(getCountry(request.getTaxNumber()).getTax()));
    }
    private Country getCountry(String taxNumber) {
        return countries.get(taxNumber.substring(0, 2).toUpperCase());
    }
}