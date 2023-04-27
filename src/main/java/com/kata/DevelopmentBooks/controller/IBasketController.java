package com.kata.DevelopmentBooks.controller;

import com.kata.DevelopmentBooks.dto.Basket;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface IBasketController {
    Basket calculateTotalPrice(@RequestBody Basket basket);
}
