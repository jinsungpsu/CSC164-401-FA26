/*
I write my own code, you fool of a Took

Mr. An
CSC164
Lab 1
8/27/26
 */

// #include <iostream>
import java.util.Scanner;

// OR import the whole util package
// this is selective, no performance penalty
// WHOLE util package
import java.util.*;


class mouse {
    // by convention
    // class names should start with
    // capital
    // but not enforced...
}

class Computer {
    double cpuSpeed;
    int ram;
    String memory;
    Monitor monitor = new Monitor();
    Monitor monitor2 = new Monitor();

    void typeMessage(String message) {
        memory = message;
    }

    void showMessageOnMonitor() {
        monitor.showMessage(memory);
    }


}

class Monitor {
    String brand;
    int pixelsX;
    int pixelsY;
    String message;

    void showMessage(String message) {
        System.out.println("my monitor is showing: ");
        System.out.println(message);
    }
}
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        // System.out.printf("Hello World, my name is Mr. An!");

        Computer mypc = new Computer();
        Computer mypc2 = new Computer();


        mypc.typeMessage("Hello World");
        mypc.showMessageOnMonitor();

        /* unrelated class examples */
        System.out.print("Hello World\n");
        // is exactly the same as
        System.out.println("Hello World");
        // println in intelliJ and many other IDE's
        // can be done using shortcut sout
        System.out.println();

        // numeric literals
        double salesTaxRateFake = 60;       // 60 is implied as double
        double salesTaxRate = 0.60;    // 0.60 is implied as double

        System.out.println(0.60);       // not an integer
                                        // but float?  double?
                                        // not fact checked but mr. An thinks it defaults to double

        System.out.println(0.60D);      // don't need to fact check
                                        // adding the D after the number
                                        // forces it to be treated as a double

        System.out.println(1E3);

        /* Scanner / keyboard input example */
        Scanner keyboard = new Scanner(System.in);

        System.out.println("How much stuff did you buy? ");
        System.out.print("Enter amount: $");
        double amountSpent = keyboard.nextDouble();
        // similar to cin >> amountSpent;

        System.out.println("####################");
        System.out.println("####################");

        System.out.print("The total spent is $ ");
        System.out.println(amountSpent);

        System.out.println("The total spent is $ " + amountSpent);

        double taxAmount = salesTaxRate * amountSpent;
        System.out.println("The tax is: $" + taxAmount);

        System.out.println("-----------------");
        double total = amountSpent + taxAmount;

        System.out.println("Total: $" + total);



    }
}
