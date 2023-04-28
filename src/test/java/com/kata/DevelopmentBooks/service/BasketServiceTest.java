package com.kata.DevelopmentBooks.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kata.DevelopmentBooks.TestUtils;
import com.kata.DevelopmentBooks.dto.Basket;
import com.kata.DevelopmentBooks.exception.BookNotFoundException;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class BasketServiceTest {

    @Mock
    IPriceService priceService;

    @Mock 
    IDiscountService discountService;

    @InjectMocks
    BasketServiceImpl basketService;

    
    @Test
    public void getBasketWithPrice() throws BookNotFoundException {
        Basket basket = TestUtils.createBasket();

        when(priceService.calculateTotalPrice(basket)).thenReturn(BigDecimal.valueOf(400));
        when (discountService.getDiscountPercentage(basket)).thenReturn(BigDecimal.valueOf(1.6));
        
        Basket processedBasket = basketService.getBasketWithPrice(basket);

        assertThat(processedBasket.getDiscountedPrice(), equalTo(BigDecimal.valueOf(320.0)));

    }
}
