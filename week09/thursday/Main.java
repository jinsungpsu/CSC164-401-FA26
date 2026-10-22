import java.util.ArrayList;

class Menu {
    private ArrayList<RestaurantItem> menuItems = new ArrayList<>();

    /*
    A setter would normally look this

    This way of doing it works, but it's a little unintuitive..
    It requires you to send in an entire ArrayList object...
    aka you're sending in ALL the menu items in at once
     */
    public void setMenuItems(ArrayList<RestaurantItem> menuItems) {
        this.menuItems = menuItems;
    }

    /*
    Instead - this way of doing... is a bit more intuitive...
    You can allow the user to just insert/add one item
    to an already existing menu
     */
    public void addMenuItem(RestaurantItem item) {
        menuItems.add(item);
    }

    public RestaurantItem getItem(int index) {
        return menuItems.get(index);
    }

    @Override
    public String toString() {
        if (menuItems.isEmpty()) {
            return "Menu is empty.";
        }

        StringBuilder output = new StringBuilder("Menu:\n");

        for (int i = 0; i < menuItems.size(); i++) {
            output.append(String.format("%d: %s%n",
                    i + 1,
                    menuItems.get(i).toString()));
        }

        return output.toString();
    }
}

class RestaurantItem {

}

class Food extends RestaurantItem {

}

class GiftCard extends RestaurantItem {

}

class Drink extends RestaurantItem {
    public void drinkydrinkydrink() {
        System.out.println("I'm a drink!");
    }
}

class Order {
    private String customerName;
    private ArrayList<RestaurantItem> itemsOrdered = new ArrayList<>();
    private double totalCost;

    // this is a class example,
    // you're not required to do this for your assignment
    public void addItem(RestaurantItem item) {
        // there are some things that we'll do
        // that are in common for any kind of item
        // you add to the order


        // but there's also some things that you might
        // do differently based on what kind fo Restaurant item
        // aka Food, Drink, or Gift Card
        // you're trying to add to your order...

        if (item instanceof Drink) {
            System.out.println("Do you want ice in your drink?");
            // right now, the item is a reference variable of the RestaurantItem class
            ((Drink) item).drinkydrinkydrink();
            // this is the same concept as
            // explicit casting back in primitive numeric types
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Simple demo
        Menu menu = new Menu();

        menu.addMenuItem(new Food("Burger", 5.99, "Gluten, Dairy"));
        menu.addMenuItem(new Drink("Soda", 2.99, "Large", true));
        menu.addMenuItem(new GiftCard("Gift Card", 25.00, 25.00, "Happy Birthday!"));

        System.out.println("Welcome to Java Bites Restaurant!");
        System.out.println(menu.toString());

        Order order = new Order("Alex Smith");

        order.addItem(menu.getItem(0)); // Add Burger
        order.addItem(menu.getItem(1)); // Add Soda

        order.calculateTotal();

        System.out.println(order.toString());
    }
}
