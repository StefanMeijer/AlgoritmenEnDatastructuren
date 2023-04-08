package com.example.eindopdracht.datastructures;

public class Queue<T> {

    private int front;
    private int rear;
    private int size;
    private int capacity;
    private T[] queue;

    public Queue(int capacity) {
        this.capacity = capacity;
        front = size = 0;
        rear = capacity - 1;
        queue = (T[]) new Object[this.capacity];
    }

    public void enqueue(T item) {
        if (isFull()) {
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public T front() {
        if (isEmpty()) {
            return null;
        }
        return queue[front];
    }

    public T rear() {
        if (isEmpty()) {
            return null;
        }
        return queue[rear];
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

    public T[] getQueue() {
        return queue;
    }
}
