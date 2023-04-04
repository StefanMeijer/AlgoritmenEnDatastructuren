package com.example.eindopdracht.algoritmes.search;

import com.example.eindopdracht.datasources.Person;
import com.example.eindopdracht.datastructures.Queue;

public class LinearSearch {

    public <T extends Comparable<T>> T linearSearch(Queue<T> queue, int size, T object) {
        if (size == 0) {
            return null;
        } else {
            T item = queue.dequeue();
            int comparison = item.compareTo(object);
            if (comparison == 0) {
                return item;
            } else {
                queue.enqueue(item);
                return linearSearch(queue, size - 1, object);
            }
        }
    }

}
