package com.kata.DevelopmentBooks.service;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kata.DevelopmentBooks.TestUtils;
import com.kata.DevelopmentBooks.dto.Basket;
import com.kata.DevelopmentBooks.repository.BookRepository;
import com.kata.DevelopmentBooks.repository.SerieRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
public class DiscountSetDifferentBookTest {
    
    @MockBean
    BookRepository bookRepository;

    @MockBean
    SerieRepository serieRepository;

    @Autowired
    IDiscountService discountService;

    @Configuration
    public static class Config {
        @Bean
        public IDiscountService getStudentService() {
            return new DiscountServiceImpl();
        }
    }

    @Test
    public void calculateDiscountPercentage() {
        Basket basket = TestUtils.createBasket();

        assertThat(discountService.getDiscountPercentage(basket), equalTo(BigDecimal.valueOf(1.6)));
    }


    
}
