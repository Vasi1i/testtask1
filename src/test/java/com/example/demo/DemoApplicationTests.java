package com.example.demo;

import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(MockitoJUnitRunner.class)
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {DemoApplication.class, ConfigTest.class})
@CucumberContextConfiguration
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class DemoApplicationTests {
	@Test
	void contextLoads() {
	}
}

//	@Autowired
//	ApplicationContext context;
//@SpringBootTest
