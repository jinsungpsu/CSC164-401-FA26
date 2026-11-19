package com.example.week13app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.*;
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
    @FXML
    private Label storeNameLabel;

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
    private Text storeInventoryText;

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
        /*
        File storeInventoryFile = new File("store-inventory.txt");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(storeInventoryFile));
            String data = reader.readLine();
            while(data != null) {
                data = reader.readLine();
            }

            Scanner inventoryReader = new Scanner(storeInventoryFile);

            String inventory = "";
            while(inventoryReader.hasNextLine()) {
                inventory += inventoryReader.nextLine();
            }
            storeInventoryText.setText(inventory);
        } catch (FileNotFoundException e) {
            storeInventoryText.setText("You didn't provide the inventory file!");
        } catch (IOException e) {
            System.out.println("Buffered reader ran into an issue.");
        }

        */

        File myfile = new File("store-info.txt");
        try {
            Scanner fileScanner = new Scanner(myfile);
            String storeName = fileScanner.nextLine();
            storeNameLabel.setText(storeName);
        } catch (FileNotFoundException e) {
            System.out.println("Store name file is not found?  What shall we name this store?");
            Scanner keyboard = new Scanner(System.in);
            String tempStoreName = keyboard.nextLine();
            storeNameLabel.setText(tempStoreName);
        }




        menu = FXCollections.observableArrayList();

        File myInventoryFile = new File("store-inventory.txt");

        try {
            Scanner myInventoryScanner = new Scanner(myInventoryFile);

            String line;
            while(myInventoryScanner.hasNextLine()) { // dealing with csv deal with one line of text at at ime
                line = myInventoryScanner.nextLine(); // <- this line has ONE product with all data separated by commas
                String[] individualInventoryItemData = line.split(",");
                if (individualInventoryItemData[0].equals("Phone")) {
                    // then it's a phone
                    // individualInventoryItemData[0] -> what kind of product is it?  AKA class name
                    // individualInventoryItemData[1] -> product name
                    // individualInventoryItemData[2] -> price (make sure you trim this string, because it might have a space at beginning or end)
                    // individualInventoryItemData[3] -> phone number
                    Phone phone = new Phone(individualInventoryItemData[1],Double.parseDouble(individualInventoryItemData[2].trim()), individualInventoryItemData[3] );
                    menu.add(phone);
                } else if (individualInventoryItemData[0].equals("Product")) {
                    // then it's a product
                    // individualInventoryItemData[0] -> what kind of product is it?  AKA class name
                    // individualInventoryItemData[1] -> product name
                    // individualInventoryItemData[2] -> price
                    // individualInventoryItemData[3] -> this is a product - does NOT have a phone #!!!
                    String productName = individualInventoryItemData[1];
                    String productPrice = individualInventoryItemData[2];
                    
                    // nameOfMyListView.getItems().add(productName + " $" + productPrice.trim());
                    

                } else if (individualInventoryItemData[0].equals("Computer")) {
                    // then it's a computer
                    // individualInventoryItemData[0] -> what kind of product is it?  AKA class name
                    // individualInventoryItemData[1] -> product name
                    // individualInventoryItemData[2] -> price
                    // individualInventoryItemData[3] -> processor
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Your inventory file was missing!");
        }
        /*
        Instead of hard coding these values
        into my java source code... which means all future changes
        must be made by a programmer
        we want these values to come from a file - so that a nontech
        person can make the updates to what this store sells

        menu.add(new Computer("Mackbook pro", 1499, "M4"));
        menu.add(new Phone("Samsung S26 Ultra", 1399, "3025551234"));
        menu.add(new Product("LG OLED TV", 1299));
         */

        menuListView.setItems(menu);
    }

}
