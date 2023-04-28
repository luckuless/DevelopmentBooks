package com.kata.DevelopmentBooks.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kata.DevelopmentBooks.dto.Basket;
import com.kata.DevelopmentBooks.entity.Book;
import com.kata.DevelopmentBooks.exception.BookNotFoundException;
import com.kata.DevelopmentBooks.repository.BookRepository;

@Service
public class PriceServiceImpl implements IPriceService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public BigDecimal calculateTotalPrice(Basket basket) throws BookNotFoundException {
        BigDecimal totalPrice = BigDecimal.ZERO;

        Map<String, Integer> bookMap = basket.getBookMap();

        for (String key : bookMap.keySet()) {
            BigDecimal price = findBookByISBN(key).get().getPrice();
            totalPrice = totalPrice.add(price.multiply(BigDecimal.valueOf(bookMap.get(key))));
        }
        return totalPrice;
        
    }

    @Override
    public Optional<Book> findBookByISBN(String ISBN) throws BookNotFoundException {
        List<Book> books = bookRepository.findByISBN(ISBN);
        if (books.isEmpty()) {
            throw new BookNotFoundException("Book with ISBN "+ ISBN +" is not present in our record.");
        }
        return books.stream().findFirst();
    
    }

    
}