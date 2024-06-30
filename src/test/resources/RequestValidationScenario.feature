Feature: Request data validation

  @Product
  Scenario: Invalid request (product invalid): product value is null
    Given product null, tax number DE123456789 and coupon code D5
    Then validation is successful false

  @Product
  Scenario: Invalid request (product invalid): product value length is more than 12 digits
    Given product 1234567890123, tax number DE123456789 and coupon code D5
    Then validation is successful false

  @Tax
  Scenario: Invalid request (taxNumber invalid): tax number is null
    Given product 123456789012, tax number null and coupon code D5
    Then validation is successful false

  @Tax
  Scenario: Invalid request (taxNumber invalid): tax number has unknown country prefix
    Given product 123456789012, tax number XX123456789 and coupon code D5
    Then validation is successful false

  @Tax
  Scenario: Invalid request (taxNumber invalid): tax number has known country prefix but number of digits is incorrect
    Given product 123456789012, tax number GR12345678 and coupon code D5
    Then validation is successful false

  @CouponCode
  Scenario: Invalid request (couponCode invalid): coupon code has unknown coupon prefix
    Given product 123456789012, tax number GR12345678 and coupon code X10
    Then validation is successful false

  @CouponCode
  Scenario: Invalid request (P couponCode invalid): percentage coupon code has no digits
    Given product 123456789012, tax number GR12345678 and coupon code P
    Then validation is successful false

  @CouponCode
  Scenario: Invalid request (P couponCode invalid): percentage coupon code has only digit 0
    Given product 123456789012, tax number GR12345678 and coupon code P0
    Then validation is successful false

  @CouponCode
  Scenario: Invalid request (P couponCode invalid): percentage coupon code has two digits and first is 0
    Given product 123456789012, tax number GR12345678 and coupon code P01
    Then validation is successful false

  @CouponCode
  Scenario: Invalid request (P couponCode invalid): percentage coupon code has 3 digits number but it is not 100
    Given product 123456789012, tax number GR12345678 and coupon code P101
    Then validation is successful false

  @CouponCode
  Scenario: Invalid request (P couponCode invalid): percentage coupon code has more than 3 digits
    Given product 123456789012, tax number GR12345678 and coupon code P1000
    Then validation is successful false

  @CouponCode
  Scenario: Invalid request (D couponCode invalid): deduction coupon code has no digits
    Given product 123456789012, tax number GR12345678 and coupon code D
    Then validation is successful false

  @CouponCode
  Scenario: Invalid request (D couponCode invalid): deduction coupon code has only digit 0
    Given product 123456789012, tax number GR12345678 and coupon code D0
    Then validation is successful false

  @CouponCode
  Scenario: Invalid request (D couponCode invalid): deduction coupon code has two digits and first is 0
    Given product 123456789012, tax number GR12345678 and coupon code D01
    Then validation is successful false

  @CouponCode
  Scenario: Invalid request (D couponCode invalid): deduction coupon code has more than 6 digits
    Given product 123456789012, tax number GR12345678 and coupon code D1234567
    Then validation is successful false

  @ValidRequest
  Scenario: Valid request: all fields are correct and not null
    Given product 123456789012, tax number GR123456789 and coupon code D5
    Then validation is successful true

  @ValidRequest
  Scenario: Valid request: all fields are correct and coupon is null
    Given product 123456789012, tax number GR123456789 and coupon code D5
    Then validation is successful true

  @PaymentProcessor
  Scenario: Invalid request (paymentProcessor invalid): client is looking for payment processor which is null
    Given pricing service has two payment processors paypal and stripe
    When client makes a purchase request with product 123456789012, tax number GR123456789 and coupon code D5 to pay with null
    Then purchase request validation is successful false

  @PaymentProcessor
  Scenario: Invalid request (paymentProcessor invalid): client is looking for payment processor which is not exist
    Given pricing service has two payment processors paypal and stripe
    When client makes a purchase request with product 123456789012, tax number GR123456789 and coupon code D5 to pay with revolut
    Then purchase request validation is successful false

  @ValidRequest
  Scenario: Valid request: client is looking for existing payment processor
    Given pricing service has two payment processors paypal and stripe
    When client makes a purchase request with product 123456789012, tax number GR123456789 and coupon code D5 to pay with paypal
    Then purchase request validation is successful true