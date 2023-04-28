package com.kata.DevelopmentBooks.utils;

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
}
