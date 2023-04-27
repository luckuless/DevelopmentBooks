package com.kata.DevelopmentBooks.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kata.DevelopmentBooks.dto.Basket;
import com.kata.DevelopmentBooks.service.IPriceService;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/1.0/basket")
@Slf4j
public class BasketController implements IBasketController {

    @Autowired
    IPriceService priceService;
    
    @PostMapping("/calculate-price")
    @Override
    public Basket calculateTotalPrice(@RequestBody Basket basket) {

        BigDecimal totalPrice = priceService.calculateTotalPrice(basket);
        log.info("Total Price prior to discounts: {}", totalPrice);

        basket.setTotalPrice(totalPrice);
        
        return basket;
    }
    
}
