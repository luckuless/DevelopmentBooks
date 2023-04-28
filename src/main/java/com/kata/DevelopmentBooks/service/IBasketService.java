package com.kata.DevelopmentBooks.service;

import java.math.BigDecimal;

import com.kata.DevelopmentBooks.dto.Basket;
import com.kata.DevelopmentBooks.exception.BookNotFoundException;

public interface IBasketService {

    Basket getBasketWithPrice(Basket basket) throws BookNotFoundException;

    BigDecimal calculateTotalPrice(Basket basket) throws BookNotFoundException;

    BigDecimal processDiscount(Basket basket);
    
}
