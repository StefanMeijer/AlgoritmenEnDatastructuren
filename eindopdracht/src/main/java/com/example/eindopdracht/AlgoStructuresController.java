package com.example.eindopdracht;

import com.example.eindopdracht.algoritmes.search.LinearSearch;
import com.example.eindopdracht.datasources.Person;
import com.example.eindopdracht.datastructures.Queue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AlgoStructuresController {
    @FXML
    private Label welcomeText;

    Queue<Person> personQueue = new Queue<>(3);

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
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