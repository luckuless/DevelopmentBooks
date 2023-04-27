package com.kata.DevelopmentBooks.service;

import java.math.BigDecimal;

import com.kata.DevelopmentBooks.dto.Basket;
import com.kata.DevelopmentBooks.enums.DiscountCode;

public interface IDiscountService {
    DiscountCode getDiscountCode();

    BigDecimal getDiscountPercentage(Basket basket);
    
}
