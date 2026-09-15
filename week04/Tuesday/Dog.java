public class Dog {

    String name;
    int age;

    // a constructor MUST be called
    // when an object is created...

    // if i don't include a constructor in my class
    // java will put one in for me...

    // a default no-arg constructor
    // no parameters
    // nothing in the body

    Dog() {
        // aka, doesn't initialize anything
//        int num = 10;
//        System.out.println("look it's an int!" + num);
//        System.out.println("A constructor is just code");
//        System.out.println("Specifically - it's code that runs when an object of a class is created!  so it's usually used to initialize data within an object");
        name = "unnamed";
        age = 0;
    }

    // here's a bunch of overloaded constructors
    // no different than overloaded methods
    // just means methods with same name but different
    // parameters

    // in a design sense, the programmer decides
    // what constructors to include, based on what is
    // allowed in your program design
    // do you want to allow dogs to be created with just a name?
    // just age?
    // both?
    // none?
    // you design/include constructors accordingly

    Dog(String name, int age) {

    }

    Dog(int age) {

    }

    Dog(String name) {

    }

    void bark() {
        // the keyword "this"
        // has a very specific meaning in java
        // it is a reference variable
        // aka variable name
        // for the object itself
        // depending on what object
        // this code was called from
        // the "this" gets replaced by
        // the unique object itself

        // i don't *HAVE* write this.name...
        // but sometimes, I'll have to... more on this later
        // both of these below do work right now
        System.out.println(this.name + " says: woof!");
        System.out.println(name + " says: woof!");
    }
}

// A Driver class
class DogApp {
    public static void main(String[] args) {
        /*
        both of these do the same thing
        define a var and then give it a value
         */
        int num = 5;
        int num2;
        num2 = 5;

        // same as using a constructor with parameters


        System.out.println("The application starts here!");
        System.out.println("This code really isn't about what a dog is and what a dog does - so it doesn't really belong inside the Dog class");

        Dog airBud = new Dog();
        Dog doug = new Dog();

        airBud.name = "Air Bud";
        doug.name = "Doug the Pug";

        airBud.age = 30;
        doug.age = 8;

        airBud.bark();
        doug.bark();
    }
}

class Food {
    String name;
    String allergens;
    double price;

    Food() {

    }

    Food(String foodName, double foodPrice) {
        name = foodName;
        price = foodPrice;
        allergens = "None";
    }

    void upCharge() {
        price += price * .1;
    }
}

class RestaurantApp2 {
    public static void main(String[] args) {
        // as soon as I created a new constructor
        // that required name/price
        // if i try to create a food
        // with no initial data
        // aka no arg constructor
        // this is now a syntax error
        Food menuItem1 = new Food();
        menuItem1.name = "Burger";
        menuItem1.allergens = "Dairy, Glutten";
        menuItem1.price = 12.99;

        System.out.println("Our menu");
        System.out.printf("\nName: %s\nAllergens: %s\nPrice: $%.2f", menuItem1.name, menuItem1.allergens, menuItem1.price);

        // hike up the burger price by 10%
        // menuItem1.price += menuItem1.price * .1;
        menuItem1.upCharge();

        System.out.println("\n\nAfter price hike of 10%");

        System.out.println("Our menu");
        System.out.printf("\nName: %s\nAllergens: %s\nPrice: $%.2f", menuItem1.name, menuItem1.allergens, menuItem1.price);


    }
}
