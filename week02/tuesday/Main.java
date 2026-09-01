import java.util.Scanner;

public class Module02_Lab {
    public static void main(String[] args) {
        /*
        Q: where do i want to define variables?
        A: close to where they will be used...

        variables with a big scope/context... define them at the top

         */
        Scanner keyboard = new Scanner(System.in);

        /*
        IntelliJ Autocomplete

        For public static void main
        psvm or main

        For System.out.println
        sout
         */
        System.out.println("Hello");

        // start lab for module 2

        System.out.println("########################################");
        System.out.println("########################################");
        System.out.println("########################################");

        int number;
        System.out.println("Enter a number: ");
        number = keyboard.nextInt();

        // testing purposes
        // diagnostic output
        System.out.println("You entered the number " + number);

        int bigNumber, smallNumber;
        // camel case example
        // every new word starts
        // with a capital letter
        // start variable names with lower case
        // only use first letter upper case
        // for class names
        // example: String firstNameOfStudentInMyClass;
        System.out.println("Enter a big number: ");
        bigNumber = keyboard.nextInt();

        System.out.println("Enter a small number: ");
        smallNumber = keyboard.nextInt();

        if (bigNumber > smallNumber) {
            System.out.println("Yes your big # is in fact bigger than your small #");
        } else {
            System.out.println("Your big # is smaller... error.");
        }

        do {
            System.out.println("Enter a big number: ");
            bigNumber = keyboard.nextInt();

            System.out.println("Enter a small number: ");
            smallNumber = keyboard.nextInt();
        } while (smallNumber > bigNumber);

        bigNumber = bigNumber + 1;
        // bigNumber += 1;
        // replaced with bigNumber++; <-- post increment
        // ++bigNumber;                 <-- pre increment
        // post and pre increment
        // behave differently
        // ONLY when used in the middle of another instruction
        System.out.println(++bigNumber);
        System.out.println(bigNumber++);

        // let's say bigNumber = 100
        int calculation = 5 * 10 + (bigNumber++);
        // the previous line is 5 * 10 + 100 and THEN bigNumber becomes 101

        int calculation2 = 5 * 10 + (++bigNumber);
        // the calculation becomes 5 * 10 + 101
        // because bigNumber was increment BEFORE (pre) this calculation

        /*
        format specifier and printf examples
         */

        double price = 99.99;
        String product = "ipad";

        System.out.printf("blah blah blah... the %s is $%.2f.", product, price);

        // arrays
        int[] numbers = new int[5];

    }
}
