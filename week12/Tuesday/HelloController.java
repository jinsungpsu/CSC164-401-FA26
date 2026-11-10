package com.example.week12;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Label footerLabel;

    @FXML
    private Label headerLabel;

    @FXML
    private Label orderDetailsLabel;

    @FXML
    void addFoodToOrderHandler(ActionEvent event) {
        String orderDetails = orderDetailsLabel.getText();
        orderDetailsLabel.setText(orderDetails + "\nYou added something...");
    }

    @FXML
    void clearOrderHandler(ActionEvent event) {
        orderDetailsLabel.setText("");
    }
}
