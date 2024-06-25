//package com.example.demo.service.pricing;
//
////import com.example.demo.controller.request.PriceRequest2;
//import com.example.demo.exeption.InvalidInputException;
//import com.example.demo.repository.CouponRepository;
//import com.example.demo.repository.ProductRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//
//class PricingServiceTest {
//    @Mock
//    private ProductRepository productRepository;
//    @Mock
//    private CouponRepository couponRepository;
//
//    @InjectMocks
//    private PricingService pricingService;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    @DisplayName("Calculate price without coupon")
//    void calculatePriceWithoutCouponTest() throws InvalidInputException {
////        Product mockProduct = new Product(1L, "Iphone", new BigDecimal("100.00"));
////        when(productRepository.findById(1L)).thenReturn(Optional.of(mockProduct));
////        BaseRequest request = BaseRequest.builder().product(1L).taxNumber("DE123456789").couponCode(null).build();
////        BigDecimal totalPrice = pricingService.calculatePrice(request);
////        assertEquals(new BigDecimal("119.0000"), totalPrice);
////        verify(productRepository, times(1)).findById(1L);
////        verify(couponRepository, never()).findByCode(anyString());
//    }
//
//    @Test
//    @DisplayName("Calculate price with percentage coupon")
//    void calculatePriceWithPercentageCouponTest() throws InvalidInputException {
////        Product mockProduct = new Product(1L, "Iphone", new BigDecimal("100.00"));
////        when(productRepository.findById(1L)).thenReturn(Optional.of(mockProduct));
////        Coupon mockCoupon = new Coupon(1L, "P6", new BigDecimal("6.00"), true);
////        when(couponRepository.findByCode("P6")).thenReturn(Optional.of(mockCoupon));
////        PriceRequest2 priceRequest = PriceRequest2.builder().product(1L).taxNumber("GR123456789").couponCode("P6").build();
////        BigDecimal totalPrice = pricingService.calculatePrice(priceRequest);
////        BigDecimal expectedPrice = new BigDecimal("100.00")
////                .subtract(new BigDecimal("100.00").multiply(new BigDecimal("6.00")
////                        .divide(new BigDecimal("100"))))
////                .multiply(new BigDecimal("1.24"));
////        assertThat(totalPrice, equalTo(expectedPrice));
////        verify(productRepository, times(1)).findById(1L);
////        verify(couponRepository, times(1)).findByCode("P6");
//    }
//
//    @Test
//    @DisplayName("Calculate price with fix value coupon")
//    void calculatePriceWithFixValueCouponTest() throws InvalidInputException {
////        Product mockProduct = new Product(1L, "Iphone", new BigDecimal("100.00"));
////        when(productRepository.findById(1L)).thenReturn(Optional.of(mockProduct));
////        Coupon mockCoupon = new Coupon(1L, "D10", new BigDecimal("10.00"), false);
////        when(couponRepository.findByCode("D10")).thenReturn(Optional.of(mockCoupon));
////        PriceRequest2 priceRequest = PriceRequest2.builder().product(1L).taxNumber("GR123456789").couponCode("D10").build();
////        BigDecimal totalPrice = pricingService.calculatePrice(priceRequest);
////        BigDecimal expectedPrice = new BigDecimal("100.00")
////                .subtract(new BigDecimal("10.00"))
////                .multiply(new BigDecimal("1.24"));
////        assertThat(totalPrice, equalTo(expectedPrice));
////        verify(productRepository, times(1)).findById(1L);
////        verify(couponRepository, times(1)).findByCode("D10");
//    }
//}