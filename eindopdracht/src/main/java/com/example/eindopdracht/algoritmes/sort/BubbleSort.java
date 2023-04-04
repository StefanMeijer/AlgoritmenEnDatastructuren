package com.example.eindopdracht.algoritmes.sort;

public class BubbleSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        int arrayLength  = array.length;

        for (int i = 0; i < arrayLength-1; i++) {

            for (int j = 0; j < arrayLength-i-1; j++) {

                if (array[j].compareTo(array[j+1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
