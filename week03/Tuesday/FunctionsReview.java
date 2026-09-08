import java.util.Scanner;

public class FunctionsReview {
    // in c++
    // int main()
    /*
    check input function...

    function prototype
    bool checkInput(int num, int low, int high);

     */
    public static void main(String[] args) {

        welcomeMessage();

        enterNumber();

        Scanner keyboard = new Scanner(System.in);

        int number = keyboard.nextInt();

        System.out.println("You entered " + number);

        boolean validNumber = checkInput(number, 0, 100);

        if (validNumber) {
            System.out.printf("\n\n%d is in fact between %d and %d", number, 0, 100);
        } else {
            System.out.printf("\n\n%d is in NOT between %d and %d", number, 0, 100);
        }

    }

    // differences in java
    // order does NOT mater
    // you can put them anywhere... below or above main
    // typically, do keep it below main....
    // also... we're gonna add "static" in front of the function
    // no prototype needed

    static void welcomeMessage() {
        System.out.println("Hello!");
        System.out.println("welcome to my program");
    }

    /*
    This method checks whether the parameter num
    is within the range of low >= num >= high
    and returns true if it is within range
    and returns false if it is not
     */
    static boolean checkInput(int num, int low, int high) {
        /*
        as if you first declare 3 variables
        these only exist here within the black box
        int num;
        int low;
        int high;

        these three variables are initialized with the
        data that was sent in from the outside world
         */


        if (num >= low && num <= high) return true;
        else return false;
    }

    static int enterNumber() {
        return 5;
    }


}
