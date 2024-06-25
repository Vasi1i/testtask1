//package com.example.demo.controller;
//
//import com.example.demo.service.pricing.PricingService;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.stream.Stream;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@WebMvcTest(PurchaseController.class)
//class PurchaseControllerPriceRequestValidationTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private PricingService pricingService;
//
//    static Stream<String> requestIncorrectBodies() {
//        return Stream.of(
//                "{\"product\": 1, \"taxNumber\": \"IT12345678900\", \"couponCode\": \"D15\", \"paymentProcessor\": \"\"}",
//                "{\"product\": 1, \"taxNumber\": \"IT12345678900\", \"couponCode\": \"D15\", \"paymentProcessor\": \"null\"}",
//                "{\"product\": null, \"taxNumber\": \"IT12345678900\", \"couponCode\": \"D15\", \"paymentProcessor\": \"paypal\"}",
//                "{\"product\": 1, \"taxNumber\": \"IT12345678900X\", \"couponCode\": \"D15\", \"paymentProcessor\": \"paypal\"}",
//                "{\"product\": 1, \"taxNumber\": \"IT12345678900\", \"couponCode\": \"D150\", \"paymentProcessor\": \"paypal\"}"
//        );
//    }
//
//    @ParameterizedTest
//    @DisplayName("Get Bad Request (status 400) if PurchaseRequest 'paymentProcessor' field is incorrect")
//    @MethodSource("requestIncorrectBodies")
//    void validatePriceRequest(String requestBody) throws Exception {
//        mockMvc.perform(post("/purchase")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestBody)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest());
//    }
//
//    @Test
//    @DisplayName("Get Ok (status 200) if all PurchaseRequest fields are correct")
//    void priceRequestOKTest() throws Exception {
//        mockMvc.perform(post("/purchase")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"product\": 1, \"taxNumber\": \"IT12345678900\", \"couponCode\": \"D15\", \"paymentProcessor\": \"paypal\"}")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//}