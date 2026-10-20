package mod6;

import java.util.ArrayList;

class Vehicle {
    private String model;
    private String brand;
    private int miles;
    private double speed;

    public Vehicle(String model, String brand) {
        this.model = model;
        this.brand = brand;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Vehicle!\n" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", miles=" + miles +
                ", speed=" + speed +
                "}\n";
    }
}


public class Car extends Vehicle {
    private String insuranceCompany;

    public Car(String model, String brand) {
        super(model, brand);
    }

    @Override
    public String toString() {
        /*
        common pattern for toString methods
        this works great, but we can improve even more!

        There is some code in here... that is really more related to vehicles than cars
         */

        String output = "";
        output += "Car: \n";
        output += "Insurance: " + insuranceCompany + "\n";
        output += super.toString() + "\n"; // <- this returns the string representation of a vehicle
        // this code below really belongs in the vehicle class
        //        output += "This car's model is: " + getModel() + "\n";
        //        output += "This car's brand is: " + getBrand() + "\n";
        //        output += "This car's speed is: " + getSpeed() + "\n";
        //        output += "This car's milage is: " + getMiles();

        return output;
    }
}

class Airplane extends Vehicle {
    private double elevation;

    public Airplane(String model, String brand) {
        super(model, brand);
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "elevation=" + elevation +
                "} " + super.toString();
    }
}

class Main {
    public static void main(String[] args) {
        Car car = new Car("Honda", "Civic");
        Vehicle scooter = new Vehicle("Razor", "Scooter");
        Airplane plane1 = new Airplane("Tesla", "Roadster");

        Vehicle[] myRichGarage = {car, scooter, plane1};

        // not required but recommended
        // tell the compiler
        // what kinds of things we'll store
        ArrayList mySecondGarage = new ArrayList();

        ArrayList<Vehicle> myThirdGarage = new ArrayList<>();

        myThirdGarage.add(car);
        myThirdGarage.add(scooter);
        myThirdGarage.add(plane1);
        myThirdGarage.add(new Car("Ferrari", "Enzo"));
        myThirdGarage.add(new Airplane("Boeing", "747"));

        // ArrayList is a class
        // there's a toString method!!!

        System.out.println("Contents of my third garage using toString method!!!");
        System.out.println(myThirdGarage);
        System.out.println("#########################");

        // what if i want to have more control over the output
        // the i would not use the tostring method, i'd write my own loop

        System.out.println("##### Contents of my garage in ArrayList using for loop ####");
        // you can do a for each or regular for loop
        for (int i = 0; i < myThirdGarage.size(); i++) {
            System.out.println("Vehicle #" + (i+1) + ": " + myThirdGarage.get(i).getBrand() + ": " + myThirdGarage.get(i).getModel());
        }
        System.out.println("##### End of my garage in ArrayList using for loop ####");

        // can do the same using for each loop
        System.out.println("##### Contents of my garage in ArrayList using for loop ####");
        // you can do a for each or regular for loop
        for (Vehicle vehicle : myThirdGarage) {
            System.out.println(" - " + vehicle.getBrand() + ": " + vehicle.getModel());
        }
        System.out.println("##### End of my garage in ArrayList using for loop ####");

        // the type of stuff you'll store
        // MUST be a class
        // can't be primitive like int
        // must use wrapper class Integer
        // this is due to polymorphism
        // primitive types aren't part of inheritance
        // aka can't be used with polymorphism
        ArrayList<Integer> nums = new ArrayList<>();

        ArrayList<String> names = new ArrayList<>();

        // because everything is in one array
        // I can write much more concise, useful code
        // that deals with all kinds of vehicles

        System.out.println("########### What's stored in my garage? ########### ");
        for (int i = 0; i < myRichGarage.length; i++) {
            System.out.println(myRichGarage[i]);
        }

        System.out.println("########### End of my garage... ###########");


//        Object car2 = new Car("Honda", "Civic");
//        Object scooter2 = new Vehicle("Razor", "Scooter");

        System.out.println(car);
        System.out.println(scooter);
    }
}
