package com.kata.DevelopmentBooks.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kata.DevelopmentBooks.entity.Serie;

public class DiscountUtils {
    
    public static void decrementArray(int[] array) {
        for (int i = 0; i< array.length; i++) {
            array[i] = array[i] - 1;
        }
    }

    public static void decrementArrayExceptIndex(int[] array, int index) {
        for (int i = 0; i< array.length; i++) {
            if (i != index)
                array[i] = array[i] - 1;
        }
    }

    public static Map<String, Integer> removeBooksPresentInSerie(Map<String, Integer> bookMap, Serie serie) {
        Map<String, Integer> finalMap = new HashMap<>();

        List<String> discountedBooks = serie.getBooks().stream().map(book -> book.getISBN()).toList();

        for (String key : bookMap.keySet()) {
            if (discountedBooks.contains(key)) {
                finalMap.put(key, bookMap.get(key));
            }
        }

        return finalMap;

    }
}
