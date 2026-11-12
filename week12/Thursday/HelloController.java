package com.example.week12;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HelloController {

    private ArrayList<String> menuItemsArrayList = new ArrayList<>();
    private ObservableList<String> fullMenuObservableList = FXCollections.observableArrayList();


    @FXML
    private TextArea allergiesTextField;

    @FXML
    private TextField foodTextField;

    @FXML
    private Label footerLabel;

    @FXML
    private Label headerLabel;

    @FXML
    private Label orderDetailsLabel;

    @FXML
    private ListView<String> orderedItemsListView;

    @FXML
    void addFoodClearButtonHandler(ActionEvent event) {
        foodTextField.setText("");
    }

    @FXML
    void addFoodCancelButtonHandler(ActionEvent event) {
        foodTextField.setText("");
    }

    @FXML
    void addFoodSubmitButtonHandler(ActionEvent event) {
        String food = foodTextField.getText();
        if (!food.isEmpty())
            fullMenuObservableList.add(food);
        foodTextField.setText("");
    }


    @FXML
    void allergiesCancelButtonHandler(ActionEvent event) {

    }

    @FXML
    void allergiesClearButtonHandler(ActionEvent event) {

    }

    @FXML
    void allergiesSubmitButtonHandler(ActionEvent event) {

    }

    @FXML
    void removeSelectedItemHandler(ActionEvent event) {
        String selectedItem = orderedItemsListView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            System.out.println("User clicked: " + selectedItem);
            fullMenuObservableList.remove(selectedItem);
        }
    }

    @FXML
    void addFoodToOrderHandler(ActionEvent event) {
        // orderedItemsListView.getItems().add("Salad");
        // String orderDetails = orderDetailsLabel.getText();
        // orderDetailsLabel.setText(orderDetails + "\nYou added something...");

        fullMenuObservableList.add("Dessert!!");
    }

    @FXML
    void clearOrderHandler(ActionEvent event) {
        orderDetailsLabel.setText("");
    }

    public void initialize() {

        // this menuItems is an ArrayList
        // ArrayList is NOT something that is related
        // to the UI
        // the UI displays things use ListView
        // but it's useful to have things that live
        // in the "back end"
        // so sometimes, we need to keep track of both
        // what's in the front (being seen in the UI)
        // vs what's in the back (stored in the app)
        // and sometimes, we need both to stay in sync

        // to stay in sync
        // we'll use the ObservableList object
        // which is going to get all the data from the ArrayList
        // and then, the ListView is going to get its data
        // from the ObservableList, which can
        // alert the ListView when changes are made to the
        // ArrayList


        menuItemsArrayList.add("Burger");
        menuItemsArrayList.add("Salad");
        menuItemsArrayList.add("Cake");

        fullMenuObservableList.setAll(menuItemsArrayList);

        orderedItemsListView.setItems(fullMenuObservableList);

    }
}
