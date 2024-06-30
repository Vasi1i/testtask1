package com.example.demo;

import com.example.demo.controller.dto.request.PriceRequest;
import com.example.demo.model.country.Country;
import com.example.demo.model.discount.Coupon;
import com.example.demo.model.product.Product;
import com.example.demo.repository.CouponRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.pricing.PricingService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PriceCalculationSteps extends DemoApplicationTests {

    @InjectMocks
    private PricingService pricingService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private CouponRepository couponRepository;

    private Map<String, Country> countries = new HashMap<>();
    private BigDecimal basePrice;
    private String taxNumber;

    private boolean percentage;
    private BigDecimal discount;

    @LocalServerPort
    private int port;

    @Given("a product base price is {}, tax number {}")
    public void givenPriceRequest(BigDecimal basePrice, String taxNumber) {

        this.basePrice = basePrice;
        this.taxNumber = taxNumber;
    }

    @When("coupon type is {} and discount is {}")
    public void couponCodeNull(boolean isPercentage, BigDecimal discount) {
        this.percentage = isPercentage;
        this.discount = discount;
    }

    @Then("final price is {}")
    public void thenFinalPrice(BigDecimal finalPrice) {
        PriceRequest priceRequest = new PriceRequest(1L, taxNumber, "P5");
        Coupon coupon = new Coupon(1L, "P5", new BigDecimal("5"), true);
        Product product = new Product(1L, "mocked", new BigDecimal("100"));
        when(productRepository.findById(any())).thenReturn(Optional.of(product));
        when(couponRepository.findByCode(any())).thenReturn(Optional.of(coupon));
        Country country = new Country("DE", "Germany", new BigDecimal("0.2"), "EUR");
        countries.put("DE", country);
    }


}