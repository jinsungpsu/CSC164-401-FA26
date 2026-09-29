package Mod5;

import java.util.Scanner;

public class OOP_Restaurant {
    public static void main(String[] args) {
        Food[] menu = {
                new Food("Burger", 5.99, "Gluten, Dairy"),
                new Food("Salad", 4.49, "Nuts"),
                new Food("Pizza", 8.99, "Gluten, Dairy"),
                new Food("Soup", 3.99, "None"),
                new Food("Pasta", 7.49, "Gluten, Dairy")
        };

        // Create an order
        Order someOrder = new Order();
        someOrder.setItem1(menu[2]); // first food item is Pizza
        someOrder.setItem2(menu[4]); // second item is pasta!

        System.out.println("First item ordered is: " + someOrder.getItem1());
        System.out.println("Second item ordered is: " + someOrder.getItem2());

        Order newOrder = new Order();
        newOrder.orderSomething(menu[0]);
        newOrder.orderSomething(menu[1]);
        // i can put this in a loop if i want...

        Order order3 = new Order();
        Scanner keyboard = new Scanner(System.in);

        for (int i = 0; i < 2; i++) { // 2 items to order
            System.out.println("Which menu item do you want to order?  (1-5)");
            int menuItemIndex = keyboard.nextInt() - 1;
            order3.orderSomething(menu[menuItemIndex]);
        }


        System.out.println("Welcome to Java Bites Restaurant!");
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            // System.out.println((i + 1) + ". " + menu[i].getName() + " - $" + menu[i].getPrice() + " (Contains: " + menu[i].getAllergens() + ")");
        }
    }
}

class Food {
    private String name;
    private double price;
    private String allergens;

    public Food(String name, double price, String allergens) {
        this.name = name;
        this.price = price;
        this.allergens = allergens;
    }
}

class Order {
    private String customerName;
    private Food item1;
    private Food item2;

    public void orderSomething(Food item) {
        if (item1 == null) {
            // they didn't order anything yet?
            item1 = item;
        } else if (item2 == null) {
            // they don't have a second item.
            item2 = item;
        } else {
            // they already ordered 2 things!
            // they can't order any more
        }

    }

    // setters & getters
    public void setItem1(Food item) {
        item1 = item;
    }

    public void setItem2(Food item) {
        item2 = item;
    }

    public Food getItem1() {
        return item1;
    }

    public Food getItem2() {
        return item2;
    }
}
