package com.example.eindopdracht;

import com.example.eindopdracht.algoritmes.search.BinarySearch;
import com.example.eindopdracht.algoritmes.sort.BubbleSort;
import com.example.eindopdracht.algoritmes.sort.MergeSort;
import com.example.eindopdracht.datasources.Person;
import com.example.eindopdracht.datastructures.LinkedList.LinkedList;
import com.example.eindopdracht.datastructures.Stack;

import com.example.eindopdracht.algoritmes.search.LinearSearch;
import com.example.eindopdracht.datastructures.Queue;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;


public class AlgoStructuresController {
    public Label linearOutput;
    private Stack<Person> stack;
    Queue<Person> personQueue;
    @FXML
    public Label stackLabel;
    @FXML
    public Button pushButton, peekButton, popButton, printButton, bubblesortButton;

    @FXML
    private TextField searchValue;

    @FXML
    private Label linkedListOutput;

    private LinkedList<Integer> linkedList;


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
        this.linkedList = new LinkedList<>();
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

    protected void printQueue() {
        Object[] objects = this.personQueue.getQueue();
        Person[] people = Arrays.copyOf(objects, this.personQueue.size(), Person[].class);

        String labelText = "";
        for (Person person : people) {
            labelText += person.info() + "\n";
        }

        linearOutput.setText(labelText);
    }

    public void pushQueue() {
        personQueue.enqueue(new Person("andrew", 25));
        personQueue.enqueue(new Person("tate", 30));
        personQueue.enqueue(new Person("tristan", 35));

        printQueue();
    }

    public void linearSearchFront() {
        LinearSearch mySearch = new LinearSearch();

        linearOutput.setText(mySearch.linearSearch(personQueue, personQueue.size(), personQueue.front()).info());
    }

    public void linearSearchRear() {
        LinearSearch mySearch = new LinearSearch();

        linearOutput.setText(mySearch.linearSearch(personQueue, personQueue.size(), personQueue.rear()).info());
    }

    @FXML
    public void initLinkedList()
    {
        linkedList.insert(72);
        linkedList.insert(18);
        linkedList.insert(39);
        linkedList.insert(94);
        linkedList.insert(51);
        linkedList.insert(73);
        linkedList.insert(21);
        linkedList.insert(78);
        linkedList.insert(9);
        linkedList.insert(60);
        linkedList.insert(27);
        linkedList.insert(48);
        linkedList.insert(11);
        linkedList.insert(20);
        linkedList.insert(58);
        linkedList.insert(6);
        linkedList.insert(20);
        linkedList.insert(71);
        linkedList.insert(94);
        linkedList.insert(22);
        linkedList.insert(19);
        linkedList.insert(98);
        linkedList.insert(39);
        linkedList.insert(95);
        linkedList.insert(39);
        linkedList.insert(49);
        linkedList.insert(60);
        linkedList.insert(89);
        linkedList.insert(86);
        linkedList.insert(43);
        linkedList.insert(57);
        linkedList.insert(53);
        linkedList.insert(28);
        linkedList.insert(43);
        linkedList.insert(10);
        linkedList.insert(1);
        linkedList.insert(76);
        linkedList.insert(87);
        linkedList.insert(16);
        linkedList.insert(2);
        linkedList.insert(81);
        linkedList.insert(33);
        linkedList.insert(56);
        linkedList.insert(97);
        linkedList.insert(26);
        linkedList.insert(29);
        linkedList.insert(82);
        linkedList.insert(92);
        linkedList.insert(84);
    }

    @FXML
    public void printLinkedList()
    {
        String output = null;
        ArrayList list = linkedList.displayableView();
        for (int i = 0; i < list.size(); i++) {
            if (i == 0)
                output = list.get(i).toString();
            else
                output+=", "+list.get(i).toString();
        }
        linkedListOutput.setText(output);
    }

    @FXML
    public void sortLinkedList()
    {
        LinkedList local = this.linkedList;
        MergeSort mergeSort = new MergeSort();
        local = mergeSort.mergeSort(local);
        this.linkedList = local;
    }

    @FXML
    public void searchLinkedList()
    {
        int key = Integer.parseInt(this.searchValue.getText());
        BinarySearch binarySearch = new BinarySearch();
        int response = binarySearch.search(linkedList, key);
        if (response >= 0)
            linkedListOutput.setText("Key is at position: "+response);
        else
            linkedListOutput.setText("Key is not present in dataset");
    }
}