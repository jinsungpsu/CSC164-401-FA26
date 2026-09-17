/*
each java file can only have one public class
and it must match the name of the file
 */
class Spaceship {
    final double DEFAULT_HP = 100;

    String name;
    double speed;
    double hp = DEFAULT_HP; // the default value for any spaceship created (unless it is overwritten)

    Spaceship(String initialName, double speed) {
        name = initialName;
        this.speed = speed;
    }

    Spaceship(String initialName) {
        name = initialName;
        speed = 50;
    }
}

class Game {
    // driver
    public static void main(String[] args) {
        String[] mainMenuOptions = new String[] {
                "Start game",
                "Load game",
                "Settings",
                "Exit"
        };
        Menu mainMenu = new Menu(mainMenuOptions);
        mainMenu.showMenu();

        Spaceship enterprise = new Spaceship("Enterprise", 1000);
        enterprise.speed = 2000;

        Spaceship apollo13 = new Spaceship("Apollo 13", 500);
        apollo13.speed = 750;

    }
}

class Menu {
    String[] options;

    // constructor that requires something
    // meaning, you cannot create a menu without an initial
    // set of options
    Menu(String[] initialMenuOptions) {

    }

    void showMenu() {
        System.out.printf("#### MENU ####");
        for (int i = 0; i < options.length; i++) {
            System.out.printf("\n%d: %s", (i+1), options[i]);
        }
        System.out.printf("\n#### #### ####");
    }
}

class Junk {

}

class Planet {

}

class Enemy {

}

class ExamReview {
    public static void main(String[] args) {

        /* make sure you practice these!!!!!!! */
//        Displays all the elements of a 1D or 2D array
//        The sum of each column or row
//        Sum of all elements
//        Average of a column or row
//        Average of all elements

        int[][] examReviewIntegers = {
                {1,2,3,99},
                {4,5,6,99},
                {7,8,9,99}
        };

        System.out.println("Display items in 2D array");
        // display all items
        for (int i = 0; i < examReviewIntegers.length; i++) {
            System.out.println(examReviewIntegers[i]);// <-- this is an array
            // displaying items in an array requires using a loop
            for (int j = 0; j < examReviewIntegers[i].length; j++) {
                System.out.println(examReviewIntegers[i][j]);
            }
        }

        for (int[] row: examReviewIntegers) {
           for (int each: row) {
               System.out.println(each);
           }
        }

        int[][] carSales = {
                {1,2}, // < justin sold 1 premium, and 2 economy cars
                {1,5}, // < max sold 1 premium, 5 economy
                {0,1}  // < ngu sold 0 premium, 1 economy
        };

        for (int[] salesperson: carSales) {
            for (int typeCarSold: salesperson) {
                
            }
        }




        int small  = 5;
        double big = 10.5;

        small = (int)big;

        int[] grades = {1,2,3}; // <- implicit size
        // this array is size 3

        System.out.println(sumArrayOfInts(grades));

        int[] grades2 = new int[3];

        // you cannot do this
        int[] grades3;
        // this doesn't work.  grades3 = {1,2,3};
        grades[1] = 5; // compiles, but runtime error
    }

    // write a method
    // that... takes an array of ints as a parameter
    // and sums all its elements and returns that sum

    static int sumArrayOfInts(int[] numbers) {
        int sum  = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum+=numbers[i];
        }
        return sum;
    }

    static double avgOfArrayOfInts(int[] numbers) {
        int sum = sumArrayOfInts(numbers);
        return (double)sum / numbers.length;
    }


    static void printMenu() {
        // blah blah blah
        /*
        how to call?
        printMenu();
         */
    }

    static String nameOfStudent(int studentId) {
        // blah blah blah
        /*
        how to call?
        String name = nameOfStudent(7001234567);
        System.out.print(nameOfStudent(70012234134));

        String[] roster = {
            "Justin",
            "Emma",
            nameOfStudent(700123456),
            "Ngu"
        };

         */

        return "hi";
    }

    static char calculateGrade(double grade) {
        // blah blah blah
        /*
        char blah = calculateGrade(79.6);
         */
        return 'c';
    }

    static char getGrade(String studentName) {
        /*
        how to call?
        char grade = getGrade("Justin");
        char grade2 = getGrade(nameOfStudent(700123456));
         */

        return 'c';
    }
}
