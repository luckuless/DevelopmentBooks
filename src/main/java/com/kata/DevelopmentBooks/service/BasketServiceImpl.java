package com.kata.DevelopmentBooks.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.DevelopmentBooks.dto.Basket;

@Service
public class BasketServiceImpl implements IBasketService {

    @Autowired
    IPriceService priceService;

    @Autowired
    IDiscountService discountService;

    @Override
    public Basket getBasketWithPrice(Basket basket) {
        Basket processedBasket = basket;
        processedBasket.setTotalPrice(priceService.calculateTotalPrice(basket));

        processedBasket.setDiscountAllowed(processDiscount(processedBasket));

        processedBasket.setDiscountedPrice(processedBasket.getTotalPrice().subtract(processedBasket.getDiscountAllowed()));

        return processedBasket;
    }

    @Override
    public BigDecimal calculateTotalPrice(Basket basket) {
        return priceService.calculateTotalPrice(basket);
    }

    @Override
    public BigDecimal processDiscount(Basket basket) {
        BigDecimal discountPercentage = discountService.getDiscountPercentage(basket);
        return discountPercentage.multiply(BigDecimal.valueOf(50));
    }

}
