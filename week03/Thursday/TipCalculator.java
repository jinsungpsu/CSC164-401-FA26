import java.util.Scanner;

public class RestaurantApp {
    static Scanner keyboard = new Scanner(System.in);
    final static double HIGH_TIP_WARNING_PERCENT = 40;

    public static void main(String[] args) {
        /*
        a bunch of stuff happened now I have a total
         */

        double subTotalBill = 68.95;
        String[] itemsOrdered = {"Steak", "Soup"};

        // I want to build a tip functionality

        double tipPercent = getTipPercent();
        double tipAmount = calculateTipAmount(subTotalBill, tipPercent);
        printReceipt(itemsOrdered, subTotalBill, tipPercent, tipAmount);
    }

    static void printReceipt(String[] items, double subTotal, double tipPercent, double tipAmount) {
        System.out.printf("\n###### receipt #########");
        System.out.printf("\nYou ordered: ");
        for (String each: items) {
            System.out.printf("\n+%s", each);
        }
        System.out.printf("\nSubtotal is $%.2f", subTotal);
        System.out.printf("\nTip %%: %.2f, $%.2f", tipPercent, tipAmount);
        System.out.printf("\nTotal $%.2f", (subTotal+tipAmount));
    }

    static double calculateTipAmount(double subTotal, double tipPercent) {
        return subTotal * tipPercent/100;
    }


    static double getTipPercent() {
        double tipPercent;
        do {
            System.out.println("Please enter tip %: ");
            tipPercent = keyboard.nextDouble();
        } while (!validateRange(tipPercent, 0));
        if (tipPercent > HIGH_TIP_WARNING_PERCENT) {
            System.out.println("You sure you want to tip that much, big spender??");
        }
        return tipPercent;
    }

    static boolean validateRange(double value, double low) {
        if (value < low) {
            return false;
        } else {
            return true;
        }
    }
}
