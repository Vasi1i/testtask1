package com.example.demo;

import com.example.demo.repository.CouponRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.pricing.PricingService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@Testcontainers
@TestPropertySource(locations = "classpath:application-test.properties")
@ContextConfiguration(classes = {ConfigTest.class})
public class ControllerSteps {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:16")
            .withInitScript("test.sql");

    @Autowired
    PricingService pricingService;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CouponRepository couponRepository;

    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test() throws Exception {
        System.out.println("port = " + port);
        postgreSQLContainer.withInitScript("test.sql").start();
        ResultActions resultActions = mockMvc.perform(post("/calculate-price")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"product\": 1, \"taxNumber\": \"DE123456789\", \"couponCode\": \"D5\"}")
                        .accept(MediaType.APPLICATION_JSON));
        System.out.println("resultActions = " + resultActions);
        String response = resultActions.andReturn().getResponse().getContentAsString();
        System.out.println("response = " + response);
        while (true) {

        }
    }

    @Given("controller a product base price is {}, tax number {} and coupon code {}")
    public void givenPriceRequest(BigDecimal basePrice, String taxNumber, String couponCode) throws Exception {
        test();

    }

    @Then("controller final price is {}")
    public void thenFinalPrice(BigDecimal finalPrice) {

    }
}