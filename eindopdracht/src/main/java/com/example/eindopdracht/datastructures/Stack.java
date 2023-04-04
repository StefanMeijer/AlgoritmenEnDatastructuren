package com.example.eindopdracht.datastructures;

import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> stack;

    public Stack() {
        this.stack = new ArrayList<T>();
    }

    /**
     * Returns the size of the stack
     * Uses size of ArrayList minus 1. This due to ArrayList.size() counts from 1 instead of 0
     * @return integer
     */
    public int size() {
        return this.stack.size() - 1;
    }

    /**
     * See object that is on top of stack
     * @return object
     */
    public T peek() {
        return this.stack.get(this.size()); //Get last element on ArrayList
    }

    /**
     * Add(push) object to top of stack
     * @param object object
     */
    public void push(T object) {
        this.stack.add(object); //Add object to top
    }

    /**
     * Remove(pop) the last object added to stack
     */
    public void pop() {
        this.stack.remove(this.size()); //Removes top object
    }

    /**
     * Function to empty the stack
     */
    public void empty () {
        this.stack.clear();
    }

    /**
     * @return Arraylist of all objects in stack
     */
    public ArrayList<T> getStack() {
        return this.stack;
    }
}
