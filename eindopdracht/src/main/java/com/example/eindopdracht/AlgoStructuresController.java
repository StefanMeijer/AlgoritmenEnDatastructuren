package com.example.eindopdracht;

import com.example.eindopdracht.algoritmes.sort.BubbleSort;
import com.example.eindopdracht.datasources.Person;
import com.example.eindopdracht.datastructures.Stack;

import com.example.eindopdracht.algoritmes.search.LinearSearch;
import com.example.eindopdracht.datastructures.Queue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Arrays;

public class AlgoStructuresController {
    private Stack<Person> stack;
    Queue<Person> personQueue;
    @FXML
    public Label stackLabel;
    @FXML
    public Button pushButton, peekButton, popButton, printButton, bubblesortButton;
    @FXML
    private void initialize() {
        this.peekButton.setDisable(true);
        this.popButton.setDisable(true);
        this.printButton.setDisable(true);
        this.bubblesortButton.setDisable(true);
    }
    public AlgoStructuresController() {
        this.stack = new Stack<>(); //Create new stack
        this.personQueue = new Queue<>(3);
    }

    /**
     * Function to print stack to screen
     * Uses info method inside Object class to print out information about info
     */
    @FXML
    protected void printStack () {
        Object[] objects = this.stack.getStack();
        Person[] people = Arrays.copyOf(objects, this.stack.size(), Person[].class);

        String labelText = "";
        for (Person person : people) {
            labelText += person.info() + "\n";
        }

        stackLabel.setText(labelText);
    }

    /**
     * Function to print the peek of the stack
     */
    @FXML
    protected void peekStack () {
        stackLabel.setText(this.stack.peek().info());
    }

    /**
     * Function to add person objects to stack
     */
    @FXML
    protected void addPersonsToStack() {
        pushButton.setDisable(true);
        this.peekButton.setDisable(false);
        this.popButton.setDisable(false);
        this.printButton.setDisable(false);
        this.bubblesortButton.setDisable(false);

        //Push dataset
        stack.push(new Person("Stefan", 70));
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
        if (!this.stack.isEmpty()) {
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
        if (!this.stack.isEmpty()) {
            //Currently only works with person, because FXML doesn't allow generic types...
            Person[] array = new Person[stack.size()]; //Creates new array with length of total objects in stack

            //Add stack objects to array
            for (int i = 0; i < array.length; i++) {
                array[i] = stack.peek(); //Get first object of stack and add it to array
                stack.pop(); //Remove it from stack for next loop to get new object
            }

            //Sort the array
            BubbleSort.sort(array);

            //Add objects back to stack
            for (Person person : array) {
                stack.push(person);
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