package com.kata.DevelopmentBooks.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Service;

import com.kata.DevelopmentBooks.dto.Basket;
import com.kata.DevelopmentBooks.enums.DiscountCode;
import com.kata.DevelopmentBooks.utils.DiscountUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DiscountServiceImpl implements IDiscountService {

    public static final Double[] DISCOUNT_DOUBLES = { 0.0, 0.1, 0.3, 0.8, 1.25 };

    DiscountUtils discountUtils;

    @Override
    public DiscountCode getDiscountCode() {
        return DiscountCode.DISCOUNT_SINGLE_DIFFERENT_BOOKS;
    }

    @Override
    public BigDecimal getDiscountPercentage(Basket basket) {
        BigDecimal discount = BigDecimal.ZERO;

        Integer[] countIntegerBooksByISBN = basket.getBookMap().values().toArray(new Integer[0]);

        Arrays.sort(countIntegerBooksByISBN, Collections.reverseOrder());

        int[] countByISBN = ArrayUtils.toPrimitive(countIntegerBooksByISBN);

        log.info("Number of books by ISBN ordered in decending order: {}", Arrays.toString(countByISBN));

        int end = countByISBN.length - 1;

        while (end != 0) {
            if (end == 4) {
                if ((countByISBN[end] + countByISBN[end - 1]) <= countByISBN[end - 2]) {
                    log.info("edge case detected");
                    while (countByISBN[end] > 0) {
                        DiscountUtils.decrementArrayExceptIndex(countByISBN, end - 1);
                        discount = discount.add(BigDecimal.valueOf(DISCOUNT_DOUBLES[end - 1]));
                    }
                    end -= 1;
                }
            }

            while (countByISBN[end] > 0) {
                DiscountUtils.decrementArray(countByISBN);
                discount = discount.add(BigDecimal.valueOf(DISCOUNT_DOUBLES[end]));
            }

            end -= 1;

        }

        return discount;
    }

}