package com.example.eindopdracht;

import com.example.eindopdracht.algoritmes.sort.BubbleSort;
import com.example.eindopdracht.datasources.Person;
import com.example.eindopdracht.datastructures.Stack;

import com.example.eindopdracht.algoritmes.search.LinearSearch;
import com.example.eindopdracht.datasources.Person;
import com.example.eindopdracht.datastructures.Queue;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AlgoStructuresController {
    private Stack<Person> stack;
    Queue<Person> personQueue = new Queue<>(3);
    
    @FXML
    public Label stackLabel;


    public AlgoStructuresController() {
        this.stack = new Stack<>(); //Create new stack
    }

    /**
     * Function to print stack to screen
     * Uses info method inside Object class to print out information about info
     */
    @FXML
    protected void printStack () {
        for (int i = this.stack.getStack().size() - 1; i >= 0; i--) {
            System.out.println(this.stack.getStack().get(i).info());
        }

        System.out.println();
    }


    /**
     * Function to print the peek of the stack
     */
    @FXML
    protected void peekStack () {
        System.out.println(this.stack.peek().info());
        System.out.println();
    }

    /**
     * Function to add person objects to stack
     */
    @FXML
    protected void addPersonsToStack() throws Exception {
        if (!this.stack.getStack().isEmpty()) {
            this.stack.empty();
        }

        //Push dataset
        stack.push(new Person("Stefan", 20));
        stack.push(new Person("Robin", 80));
        stack.push(new Person("Nick", 40));
        stack.push(new Person("Hajo", 60));

        //Print the stack to screen
        this.printStack();
    }

    /**
     * Function to pop object(top) from stack
     */
    @FXML
    protected void popStack() {
        if (!this.stack.getStack().isEmpty()) {
            this.stack.pop();

            //Print the stack to screen
            this.printStack();
        } else {
            stackLabel.setText("Stack is empty!");
        }
    }

    /**
     * Function to bubble sort stack
     */
    @FXML
    protected void bubbleSortStack () {
        if (!this.stack.getStack().isEmpty()) {
            Person[] array = new Person[stack.getStack().size()]; //Creates new array with length of total objects in stack - uses ArrayList.size() because stack size has -1

            //Add stack objects to array
            for (int i = 0; i < array.length; i++) {
                array[i] = stack.peek(); //Get first object of stack and add it to array
                stack.pop(); //Remove it from stack for next loop to get new object
            }

            //Sort the array
            BubbleSort.sort(array);

            //Add objects back to stack
            for (int i = 0; i < array.length; i++) {
                stack.push(array[i]);
            }

            //Print the stack to screen
            this.printStack();
        } else {
            stackLabel.setText("Stack is empty!");
        }
    }
    
    public void pushPeople() {
        personQueue.enqueue(new Person("andrew", 25));
        personQueue.enqueue(new Person("tate", 30));
        personQueue.enqueue(new Person("tristan", 35));
    }


    public void showValue() {
        LinearSearch mySearch = new LinearSearch();

        System.out.println(mySearch.linearSearch(personQueue, personQueue.size(), personQueue.front()));
    }
}