package com.kata.DevelopmentBooks;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.kata.DevelopmentBooks.dto.Basket;

public class TestUtils {

    public static Basket createBasket() {
        Basket basket = new Basket();
        Map<String, Integer> bookMap = new HashMap<>();
        bookMap.put("Clean Code", 2);
        bookMap.put("The Clean Coder", 2);
        bookMap.put("Clean Architecture", 2);
        bookMap.put("Test Driven Development by Example", 1);
        bookMap.put("Working Effectively With Legacy Code", 1);

        basket.setBookMap(bookMap);

        return basket;

    }

    public static Basket createBasket_withPrice() {
        Basket basket = new Basket();
        Map<String, Integer> bookMap = new HashMap<>();
        bookMap.put("Clean Code", 2);
        bookMap.put("The Clean Coder", 2);
        bookMap.put("Clean Architecture", 2);
        bookMap.put("Test Driven Development by Example", 1);
        bookMap.put("Working Effectively With Legacy Code", 1);

        basket.setBookMap(bookMap);
        basket.setDiscountAllowed(BigDecimal.valueOf(80));
        basket.setTotalPrice(BigDecimal.valueOf(400));
        basket.setDiscountedPrice(BigDecimal.valueOf(320));

        return basket;

    }

}
