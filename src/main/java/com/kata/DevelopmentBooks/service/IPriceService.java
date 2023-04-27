package com.kata.DevelopmentBooks.service;

import java.math.BigDecimal;
import java.util.Optional;

import com.kata.DevelopmentBooks.dto.Basket;
import com.kata.DevelopmentBooks.entity.Book;

public interface IPriceService {

    BigDecimal calculateTotalPrice(Basket basket);
    Optional<Book> findBookByISBN(String ISBN);

}
