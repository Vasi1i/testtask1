package com.example.demo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@ContextConfiguration(classes = {ConfigTest.class})
@TestPropertySource(locations = "classpath:application-test.properties")
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "com.example.demo")
public class CucumberRunnerTest {
}