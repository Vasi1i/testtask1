Feature:  Price controller and purchase controller testing for correct response

  Scenario: controller request a product price without discount coupon
    Given controller a product base price is 123, tax number DE123456789 and coupon code null
    Then controller final price is 123

  Scenario: controller request a product price with percentage discount coupon
    Given controller a product base price is 123, tax number DE123456789 and coupon code P10
    Then controller final price is 123

  Scenario: controller request a product price with   discount coupon
    Given controller a product base price is 123, tax number DE123456789 and coupon code D5
    Then controller final price is 123