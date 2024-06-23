package com.example.demo.controller;

import com.example.demo.service.pricing.PricingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PriceController.class)
class PriceControllerRequestValidationTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PricingService pricingService;

    static Stream<String> requestIncorrectBodies() {
        return Stream.of(
                "{\"product\": null, \"taxNumber\": \"DE123456789\", \"couponCode\": \"D11\"}",
                "{\"product\": 1, \"taxNumber\": \"DE123456789A\", \"couponCode\": \"D11\"}",
                "{\"product\": 1, \"taxNumber\": \"DE123456789\", \"couponCode\": \"D121\"}"
        );
    }

    @ParameterizedTest
    @DisplayName("Get Bad Request (status 400) if PriceRequest field is incorrect")
    @MethodSource("requestIncorrectBodies")
    void validatePriceRequest(String requestBody) throws Exception {
        mockMvc.perform(post("/calculate-price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Get Ok (status 200) if all PriceRequest fields are correct")
    void priceRequestOKTest() throws Exception {
        mockMvc.perform(post("/calculate-price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"product\": 1, \"taxNumber\": \"DE123456789\", \"couponCode\": \"D15\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}