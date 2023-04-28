package com.kata.DevelopmentBooks.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.DevelopmentBooks.dto.Basket;
import com.kata.DevelopmentBooks.exception.BookNotFoundException;

@Service
public class BasketServiceImpl implements IBasketService {

    @Autowired
    IPriceService priceService;

    @Autowired
    IDiscountService discountService;

    @Override
    public Basket getBasketWithPrice(Basket basket) throws BookNotFoundException {
        Basket processedBasket = basket;
        processedBasket.setTotalPrice(priceService.calculateTotalPrice(basket));

        processedBasket.setDiscountAllowed(processDiscount(processedBasket));

        processedBasket.setDiscountedPrice(processedBasket.getTotalPrice().subtract(processedBasket.getDiscountAllowed()));

        return processedBasket;
    }

    @Override
    public BigDecimal calculateTotalPrice(Basket basket) throws BookNotFoundException {
        return priceService.calculateTotalPrice(basket);
    }

    @Override
    public BigDecimal processDiscount(Basket basket) {
        BigDecimal discountPercentage = discountService.getDiscountPercentage(basket);
        return discountPercentage.multiply(BigDecimal.valueOf(50));
    }

}
