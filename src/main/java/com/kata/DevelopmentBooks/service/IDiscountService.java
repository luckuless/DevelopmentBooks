package com.kata.DevelopmentBooks.service;

import java.math.BigDecimal;
import java.util.Map;

import com.kata.DevelopmentBooks.dto.Basket;
import com.kata.DevelopmentBooks.enums.DiscountCode;

public interface IDiscountService {
    DiscountCode getDiscountCode();

    BigDecimal getDiscountPercentage(Basket basket);

    Map<String, Integer> getMapOfApplicableDiscountedBooks(Basket basket);
    
}
