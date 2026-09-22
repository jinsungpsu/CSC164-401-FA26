import java.util.Scanner;

public class Week05 {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

    }
}

class Phone {
    private String brand;
    private int number;
    private boolean isActive;

    // setters will always follow the same pattern
    // 1.visibility modifier is public
    // 2. return type void
    // 3. name of method: set + var name (camelCase)
    // parameter: the data type of whatever you're trying to set
    // + the name of the variable you're trying to set

    // if i want a setter for int number

    // in the body of the setters
    // somewhere, I'll have something like this.number = number;
    public void setNumber(int number) {
        /*
        instead of giving direct access
        I'm defining a specific way to be able
        to "set" the data for number... aka
        I can have more code
        aka I can provide some protections
         */
        // Must be exactly 7 digits
        if (number < 1_000_000 || number > 9_999_999) {
            // you're allowed to use underscore as a visual
            // separator for numerical values (literals)
            System.out.println("Phone # must be 7 digits");
        }
        // Cannot start with 911
        else if (String.valueOf(number).startsWith("911")) {
            System.out.println("Phone number cannot start with 911");
        } else {
            this.number = number;
            isActive = true;
        }
    }

    // getter
    // always same pattern
    // 1. public
    // 2. return type is same as whatever variable you're trying to get
    // 3. name of method is always get + name of variable (camelCase)
    // 4. no parameters
    // 5. body is also usually the same.
    //      return the variable data.

    public int getNumber() {
        return number;
    }

    // for booleans, you often use is intead of get
    public boolean isActive() {
        return isActive;
    }

}

class PhoneApp {
    public static void main(String[] args) {
        Phone phone3; // <- not an object
        // it's a ref var
        // phone3.setNumber(2131342); <- this doesn't work, because object doesn't exist
        // how do we fix this?
        // Phone phone3 = new Phone();

        Phone[] familyPlan = new Phone[5];
        // the previous line creates an array
        // of 5 reference variables
        // NOT 5 objects of the phone class
        // familyPlan[0].setNumber(1234567);
        // this doesn't work
        // Cannot invoke "Phone.setNumber(int)" because "familyPlan[0]" is null
        // how do we fix this error?
        // same as above!!!
        // we create the object
        // how do we create the object?  call the constructor!
        familyPlan[0] = new Phone();
        familyPlan[0].setNumber(1234567);

        // alternatively - we can loop through
        familyPlan[1] = new Phone();
        familyPlan[2] = new Phone();
        familyPlan[3] = new Phone();
        familyPlan[4] = new Phone();

        for (int i = 0; i < familyPlan.length; i++) {
            familyPlan[i] = new Phone();
        }


        Phone phone1 = new Phone();
        // phone1.number = 1234567;
        // bc number is private
        phone1.setNumber(1234567);

        // can't do this
        // System.out.println("This phone's # is: " + phone1.number);
        System.out.println("This phone's # is: " + phone1.getNumber());

        Phone phone2 = new Phone();
        phone2.setNumber(9111234);
        phone2.setNumber(12345678);
        phone2.setNumber(411);

        Scanner keyboard = new Scanner(System.in);

        do {
            System.out.println("What number do you want?");
            int requestNumber = keyboard.nextInt();
            phone2.setNumber(requestNumber);
        }while(!phone2.isActive());


    }
}
