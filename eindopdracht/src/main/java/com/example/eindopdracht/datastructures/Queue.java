package com.example.eindopdracht.datastructures;

public class Queue<T> {

    private int front;
    private int rear;
    private int size;
    private int capacity;
    private T[] array;

    public Queue(int capacity) {
        this.capacity = capacity;
        front = size = 0;
        rear = capacity - 1;
        array = (T[]) new Object[this.capacity];
    }

    public void enqueue(T item) {
        if (isFull()) {
            return;
        }
        rear = (rear + 1) % capacity;
        array[rear] = item;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T item = array[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public T front() {
        if (isEmpty()) {
            return null;
        }
        return array[front];
    }

    public T rear() {
        if (isEmpty()) {
            return null;
        }
        return array[rear];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (size == capacity);
    }

    public int size() {
        return size;
    }
}
