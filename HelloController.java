package com.example.demo3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField usernameField;

    @FXML
    private TextField contactField;

    @FXML
    private TextField postalField;

    @FXML
    private Label outputLabel;

    public void onSubmitButtonClicked() {
        String username = usernameField.getText();
        String contact = contactField.getText();
        String postal = postalField.getText();

        boolean isValid = true;
        StringBuilder validationMessage = new StringBuilder();

        // Validate username
        if (!username.matches("^[A-Z][a-zA-Z]*$")) {
            validationMessage.append("Invalid username. It should start with an uppercase letter and contain only letters.\n");
            isValid = false;
        }

        // Validate contact number
        if (!contact.matches("^\\d{10}$")) {
            validationMessage.append("Invalid contact number. It should be exactly 10 digits.\n");
            isValid = false;
        }

        // Validate postal code
        if (!postal.matches("^[A-Za-z]\\d[A-Za-z][ -]?\\d[A-Za-z]\\d$")) {
            validationMessage.append("Invalid postal code. Acceptable formats: P6R 2V8, P6r-2V8, p6r 2v8, p6r-2v8.\n");
            isValid = false;
        }

        if (isValid) {
            validationMessage.append("All inputs are valid.");
        }

        outputLabel.setText(validationMessage.toString());
    }
}
