package com.example.demo;

import com.example.demo.controller.request.PurchaseRequest;
import com.example.demo.controller.response.PurchaseResponse;
import com.example.demo.service.payment.PaymentProcessor;
import com.example.demo.service.payment.PaypalProcessor;
import com.example.demo.service.payment.StripeProcessor;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class StepDefs extends CucumberValidationTest {


    @Autowired
    private Map<String, PaymentProcessor> payments;

    RestTemplate restTemplate;

    @Given("Pricing Service has two payment processors {} and {}")
    public void initPayments(String paymentProcessor1, String paymentProcessor2) {
        payments.clear();
        payments.put(paymentProcessor1, new PaypalProcessor());
        payments.put(paymentProcessor2, new StripeProcessor());
    }

    @When("Client make a request to API to pay with revolut")
    @Test
    public void clientMakeARequestToAPIToPayWithRevolut() {
        PurchaseRequest purchaseRequest = PurchaseRequest.builder()
                .product(1L)
                .taxNumber("DE123456789")
                .couponCode("D15")
                .paymentProcessor("revolut").build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<PurchaseRequest> requestEntity = new HttpEntity<>(purchaseRequest, headers);
        try {
            ResponseEntity<PurchaseResponse> response = restTemplate.postForEntity(
                    "http://localhost:8080/purchase",
                    requestEntity,
                    PurchaseResponse.class
            );
            System.out.println("Response: " + response.getBody());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}