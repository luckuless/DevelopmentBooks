package com.kata.DevelopmentBooks.dto;

import java.math.BigDecimal;
import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Basket {
    Map<String, Integer> bookMap;

    BigDecimal price;

    BigDecimal discountAllowed;

    BigDecimal discountedPrice;
}
