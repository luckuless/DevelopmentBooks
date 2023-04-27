package com.kata.DevelopmentBooks.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.any;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kata.DevelopmentBooks.TestUtils;
import com.kata.DevelopmentBooks.dto.Basket;
import com.kata.DevelopmentBooks.entity.Book;
import com.kata.DevelopmentBooks.repository.BookRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class PriceServiceTest {
    

    @MockBean
    BookRepository bookRepository;

    @Autowired
    IPriceService priceService;

    @Configuration
    public static class Config {
        @Bean
        public IPriceService getStudentService() {
            return new PriceServiceImpl();
        }
    }

    @Test
    void calculateTotalPrice() {
        Basket basket = TestUtils.createBasket();

        Book book = new Book();
        book.setPrice(BigDecimal.valueOf(50));

        Mockito.when(bookRepository.findByISBN(any())).thenReturn(List.of(book));

        BigDecimal totalPrice =  priceService.calculateTotalPrice(basket);

        assertThat(BigDecimal.valueOf(400), equalTo(totalPrice));
        
    }
}
