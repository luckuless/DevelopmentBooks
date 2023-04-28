package com.kata.DevelopmentBooks.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
import com.kata.DevelopmentBooks.entity.Serie;
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

        Serie serie = TestUtils.createSerie_withDiscount();

        when(serieRepository.findByDiscountCode(any())).thenReturn(List.of(serie));

        assertThat(discountService.getDiscountPercentage(basket), equalTo(BigDecimal.valueOf(1.6)));
    }

    @Test
    public void getMapOfApplicableDiscountedBooks() {
        Basket basket = TestUtils.createBasket_withOneNonDiscountBook();

        Serie serie = TestUtils.createSerie_withDiscount();

        when(serieRepository.findByDiscountCode(any())).thenReturn(List.of(serie));

        Map<String, Integer> resultMap = discountService.getMapOfApplicableDiscountedBooks(basket);

        assertThat(resultMap.keySet().size(), lessThanOrEqualTo(serie.getBooks().size()));
    }
    
}
