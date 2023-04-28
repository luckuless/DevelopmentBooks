package com.kata.DevelopmentBooks.service;

import java.math.BigDecimal;
import java.util.Optional;

import com.kata.DevelopmentBooks.dto.Basket;
import com.kata.DevelopmentBooks.entity.Book;
import com.kata.DevelopmentBooks.exception.BookNotFoundException;

public interface IPriceService {

    BigDecimal calculateTotalPrice(Basket basket) throws BookNotFoundException;
    Optional<Book> findBookByISBN(String ISBN) throws BookNotFoundException;

}
