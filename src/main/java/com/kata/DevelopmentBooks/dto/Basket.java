package com.kata.DevelopmentBooks.dto;

import java.math.BigDecimal;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Basket {
    Map<String, Integer> bookMap;

    BigDecimal totalPrice;

    BigDecimal discountAllowed;

    BigDecimal discountedPrice;
}
