package com.kata.DevelopmentBooks.service;

import java.math.BigDecimal;

import com.kata.DevelopmentBooks.dto.Basket;

public interface IBasketService {

    Basket getBasketWithPrice(Basket basket);

    BigDecimal calculateTotalPrice(Basket basket);

    BigDecimal processDiscount(Basket basket);
    
}
