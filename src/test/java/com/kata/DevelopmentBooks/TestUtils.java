package com.kata.DevelopmentBooks;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kata.DevelopmentBooks.dto.Basket;
import com.kata.DevelopmentBooks.entity.Book;
import com.kata.DevelopmentBooks.entity.Serie;
import com.kata.DevelopmentBooks.enums.DiscountCode;

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

    public static Basket createBasket_withOneNonDiscountBook() {
        Basket basket = new Basket();
        Map<String, Integer> bookMap = new HashMap<>();
        bookMap.put("Clean Code", 2);
        bookMap.put("The Clean Coder", 2);
        bookMap.put("Clean Architecture", 2);
        bookMap.put("Test Driven Development by Example", 1);
        bookMap.put("Working Effectively With Legacy Code", 1);
        bookMap.put("Book without Discount", 1);

        basket.setBookMap(bookMap);

        return basket;

    }

    public static Serie createSerie_withDiscount() {
        Serie serie = new Serie();

        serie.setId("withDiscount");
        serie.setDiscountCode(DiscountCode.DISCOUNT_SINGLE_DIFFERENT_BOOKS);

        Book book1 = new Book();
        book1.setISBN("Clean Code");

        Book book2 = new Book();
        book2.setISBN("The Clean Coder");

        Book book3 = new Book();
        book3.setISBN("Clean Architecture");

        Book book4 = new Book();
        book4.setISBN("Test Driven Development by Example");

        Book book5 = new Book();
        book5.setISBN("Working Effectively With Legacy Code");

        serie.setBooks(List.of(book1, book2, book3, book4, book5));

        return serie;
    }



}
