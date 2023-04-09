package com.example.eindopdracht.datastructures;

public class Stack<T> {
    private T[] stack;
    private int top;

    public Stack() {
        this.stack = (T[]) new Object[1000]; //max 1000 objects
        this.top = 0;
    }

    /**
     * Returns the size of the stack
     * @return integer
     */
    public int size() {
        return this.top;
    }

    /**
     * See object that is on top of stack
     * @return object
     */
    public T peek() {
        return stack[top - 1]; //Returns stack top -1 because array counts from 0, and top begins at 1
    }

    /**
     * Add(push) object to top of stack
     * @param object object
     */
    public void push(T object) {
        stack[top++] = object; //Sets top +1 object
    }

    /**
     * Remove(pop) the last object added to stack
     */
    public void pop() {
        stack[top] = null; //set stack data of top to null
        top--; //Reduce top by -1
    }

    /**
     * Function to empty the stack
     */
    public void empty () {
        this.stack = null;
        this.top = 0;
    }

    /**
     * Function to check if the stack is empty
     * @return boolean
     */
    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * Getters/setters
     */
    public T[] getStack() {
        return stack;
    }

    public void setStack(T[] stack) {
        this.stack = stack;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
}
