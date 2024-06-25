Feature: Testing validation of payment processor from user request
  Scenario: Client is looking for payment processor which is not exist
    Given Pricing Service has two payment processors paypal and stripe
    When Client make a request to API to pay with revolut