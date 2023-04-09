package com.example.eindopdracht.algoritmes.sort;

import com.example.eindopdracht.datastructures.LinkedList.LinkedList;
import com.example.eindopdracht.datastructures.LinkedList.Node;

public class MergeSort<T extends Comparable<T>> {

    public LinkedList<T> mergeSort(LinkedList<T> list) {
        if (list == null || list.size() <= 1) {
            return list;
        }
        LinkedList<T> leftList = new LinkedList<>();
        LinkedList<T> rightList = new LinkedList<>();
        Node<T> current = list.getHead();
        int size = list.size();
        int mid = size / 2;
        for (int i = 0; i < mid; i++) {
            leftList.insert(current.getData());
            current = current.getNext();
        }
        for (int i = mid; i < size; i++) {
            rightList.insert(current.getData());
            current = current.getNext();
        }
        leftList = mergeSort(leftList);
        rightList = mergeSort(rightList);
        return merge(leftList, rightList);
    }

    private LinkedList<T> merge(LinkedList<T> leftList, LinkedList<T> rightList) {
        LinkedList<T> mergedList = new LinkedList<>();
        Node<T> left = leftList.getHead();
        Node<T> right = rightList.getHead();
        while (left != null && right != null) {
            if (left.getData().compareTo(right.getData()) <= 0) {
                mergedList.insert(left.getData());
                left = left.getNext();
            } else {
                mergedList.insert(right.getData());
                right = right.getNext();
            }
        }
        while (left != null) {
            mergedList.insert(left.getData());
            left = left.getNext();
        }
        while (right != null) {
            mergedList.insert(right.getData());
            right = right.getNext();
        }
        return mergedList;
    }
}

