package com.example.demo.service.pricing;

import com.example.demo.controller.dto.request.PriceRequest;
import com.example.demo.controller.dto.response.PriceResponse;
import com.example.demo.model.country.Country;
import com.example.demo.model.discount.Coupon;
import com.example.demo.model.discount.Discount;
import com.example.demo.model.product.Product;
import com.example.demo.repository.CouponRepository;
import com.example.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class PricingService {
    private final ProductRepository productRepository;
    private final CouponRepository couponRepository;
    private final Map<String, Country> countries;

    public PriceResponse calculatePrice(PriceRequest request) { //
        Product product = getProductFromDatabase(request.getProduct());
        Coupon coupon = getCouponFromDatabase(request.getCouponCode());
        Country country = getCountryFromRequest(request.getTaxNumber());
        BigDecimal price = product.getPrice();
        BigDecimal discountValue = getDiscountValue(product, coupon);
        BigDecimal tax = price.multiply(country.tax());
        BigDecimal finalPrice =  price.add(tax);
        return PriceResponse.builder()
                .productId(request.getProduct())
                .productName(product.getName())
                .basePrice(product.getPrice())
                .discountValue(discountValue)
                .tax(tax)
                .finalPrice(finalPrice)
                .currency(country.currency())
                .countryCode(country.code())
                .taxNumber(request.getTaxNumber())
                .discountCode(coupon.getDiscountCode()).build();
    }

    private Product getProductFromDatabase(long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new NoSuchElementException("Product with id " + productId + " not found"));
    }

    private Coupon getCouponFromDatabase(String discountCode) {
        return couponRepository.findByCode(discountCode)
                .orElseThrow(() -> new NoSuchElementException("Coupon with code " + discountCode + " not found"));
    }

    private Country getCountryFromRequest(String taxNumber) {
        return countries.get(taxNumber.substring(0, 2).toUpperCase());
    }

    private BigDecimal getDiscountValue(Product product, Discount discount) {
        BigDecimal discountValue = new BigDecimal("0.0");
        if (discount != null) {
            if (discount.isDiscountPercentage()) {
                discountValue = product.getPrice().multiply(discount.getDiscountValue().divide(new BigDecimal("100"), 2, RoundingMode.HALF_UP));
            } else {
                discountValue = discount.getDiscountValue();
            }
        }
        return discountValue;
    }
}