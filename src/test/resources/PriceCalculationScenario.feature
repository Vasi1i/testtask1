Feature:  Pricing service testing for calculation correctness

  Background: a product base price and tax number
    Given a product base price is 100, tax number DE123456789

  Scenario: request a product price with percentage discount coupon
    When coupon type is percentage and discount is 5
    Then final price is 123

  Scenario: request a product price with deduction discount coupon
    When coupon type is deduction and discount is 10
    Then final price is 123