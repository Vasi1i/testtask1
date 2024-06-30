package com.example.demo;

import com.example.demo.controller.dto.request.PriceRequest;
import com.example.demo.controller.dto.request.PurchaseRequest;
import com.example.demo.service.payment.PaymentProcessor;
import com.example.demo.service.payment.PaypalProcessor;
import com.example.demo.service.payment.StripeProcessor;
import com.example.demo.validator.PaymentProcessorValidator;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.validation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RequestValidationSteps {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();
    private final Map<String, PaymentProcessor> payments = new HashMap<>();
    private PriceRequest priceRequest;
    private PurchaseRequest purchaseRequest;
    private PaymentProcessorValidator paymentProcessorValidator;

    @Given("product {longOrNull}, tax number {stringOrNull} and coupon code {stringOrNull}")
    public void given(Long product, String taxNumber, String couponCode) {
        priceRequest = new PriceRequest(product, taxNumber, couponCode);
    }

    @Then("validation is successful {}")
    public void validationPriceRequest(boolean isValid) {
        Set<ConstraintViolation<PriceRequest>> violations = validator.validate(priceRequest);
        if (!isValid && violations.isEmpty()) {
            throw new AssertionError("Expected validation to fail, but it passed"); //
        } else if (isValid && !violations.isEmpty()) {
            for (ConstraintViolation<PriceRequest> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
            throw new AssertionError("Validation failed, but it was expected to pass");
        }
    }

    @Given("pricing service has two payment processors {} and {}")
    public void givenPaymentProcessors(String paymentProcessor1, String paymentProcessor2) {
        payments.put(paymentProcessor1, new PaypalProcessor());
        payments.put(paymentProcessor2, new StripeProcessor());
        paymentProcessorValidator = new PaymentProcessorValidator(payments);
    }

    @When("client makes a purchase request with product {}, tax number {} and coupon code {} to pay with {stringOrNull}")
    public void requestPaymentProcessor(Long product, String taxNumber, String couponCode, String paymentProcessor) {
        purchaseRequest = PurchaseRequest.builder()
                .product(product)
                .taxNumber(taxNumber)
                .couponCode(couponCode)
                .paymentProcessor(paymentProcessor).build();
    }

    @Then("purchase request validation is successful {}")
    public void validationPurchaseRequest(boolean isValid) {
        boolean validation = paymentProcessorValidator.isValid(purchaseRequest.getPaymentProcessor(), null);
        if (!isValid && validation) {
            throw new AssertionError("Expected validation to fail, but it passed");
        } else if (isValid && !validation) {
            throw new AssertionError("Validation failed, but it was expected to pass");
        }
    }

    @ParameterType("null|[^\\s]+")
    public String stringOrNull(String value) {
        return "null".equals(value) ? null : value;
    }

    @ParameterType("null|\\d+")
    public Long longOrNull(String value) {
        return "null".equals(value) ? null : Long.parseLong(value);
    }
}