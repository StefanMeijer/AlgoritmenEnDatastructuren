package com.example.eindopdracht;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AlgoStructuresController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}