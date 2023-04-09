package com.example.eindopdracht.algoritmes.sort;

public class BubbleSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        int arrayLength  = array.length;  // Get the length of the array

        for (int i = 0; i < arrayLength; i++) {  // Loop through the array

            for (int j = 0; j < (arrayLength - i - 1); j++) {  // Loop through the remaining unsorted objects of the array

                if (array[j].compareTo(array[j+1]) > 0) {  // If the current element is greater than the next element, compareTo will return 1
                    // Swap the two elements
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}
