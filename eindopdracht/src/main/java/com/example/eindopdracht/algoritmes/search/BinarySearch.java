package com.example.eindopdracht.algoritmes.search;

import com.example.eindopdracht.datastructures.LinkedList.LinkedList;
import com.example.eindopdracht.datastructures.LinkedList.Node;

public class BinarySearch<T extends Comparable<T>> {

    /**
     * Searches for specific data in dataset and returns position of data if found or -1 if not.
     * @param linkedList dataset to be searched
     * @param key data of item
     * @return Position of item
     */
    public int search(LinkedList<T> linkedList, T key) {
        int left = 0;
        int right = linkedList.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            Node<T> current = linkedList.getHead();
            for (int i = 0; i < mid; i++) {
                current = current.getNext(); // Traverse to the middle element
            }

            int comparison = current.getData().compareTo(key);

            if (comparison == 0) {
                return mid; // Found the key, return the index
            } else if (comparison < 0) {
                left = mid + 1; // Key is in the right half, update left
            } else {
                right = mid - 1; // Key is in the left half, update right
            }
        }

        return -1; // Key not found, return -1
    }
}