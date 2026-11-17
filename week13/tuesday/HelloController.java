package com.example.week13app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

class Computer extends Product {
    private String processor;

    public Computer(String name, double price, String processor) {
        super(name, price);
        this.processor = processor;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor='" + processor + '\'' +
                "} " + super.toString();
    }
}

class Phone extends Product {
    private String phoneNumber;

    public Phone(String name, double price, String phoneNumber) {
        super(name, price);
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phoneNumber='" + phoneNumber + '\'' +
                "} " + super.toString();
    }
}

public class HelloController {

    private ObservableList<Product> menu;

    private String customerName;

    @FXML
    private ListView<Product> customerOrderListView;

    @FXML
    private ListView<Product> menuListView;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label receiptDetailsLabel;

    @FXML
    void addToOderButtonHandler(ActionEvent event) {
        // detect what the item is
        Product selectedItem = menuListView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            // nothing was selected
            return;
        } else {
            customerOrderListView.getItems().add(selectedItem);
        }
    }

    @FXML
    void checkoutButtonHandler(ActionEvent event) {
        double total = calculateOrderTotal();

        receiptDetailsLabel.setText("######################" +
                "\nCustomer Order Receipt: " +
                "\nName: " + customerName +
                "\nTotal is: " + total);
    }

    private double calculateOrderTotal() {
        double total = 0;
        for (int i = 0; i < customerOrderListView.getItems().size(); i++) {
            Product each = customerOrderListView.getItems().get(i);
            total += each.getPrice();
        }
        return total;
    }

    @FXML
    void nameSubmitButtonHandler(ActionEvent event) {
        customerName = nameTextField.getText();
    }

    @FXML
    void removeFromOrderButtonHandler(ActionEvent event) {
        // detect what the item is
        Product selectedItem = customerOrderListView.getSelectionModel().getSelectedItem();
        if (selectedItem == null) {
            // nothing was selected
            return;
        } else {
            customerOrderListView.getItems().remove(selectedItem);
        }
    }
    
    private void updateListView() {
        // pretend there's a ArrayList called menu
        // and a listview called menuListView
        // manually update a ListView using
        // a loop
        menuListView.getItems().clear();
        for (int i = 0; i < menu.size(); i++) {
            menuListView.getItems().add(menu.get(i));
        }
    }

    public void initialize() {
        File myfile = new File("sample-data2.txt");
        try {
            Scanner fileScanner = new Scanner(myfile);
            System.out.println("Successfully opened that file!");
            System.out.println(fileScanner.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println("Can't find that file!");
        }


        menu = FXCollections.observableArrayList();

        menu.add(new Computer("Mackbook pro", 1499, "M4"));
        menu.add(new Phone("Samsung S26 Ultra", 1399, "3025551234"));
        menu.add(new Product("LG OLED TV", 1299));

        menuListView.setItems(menu);
    }

}
