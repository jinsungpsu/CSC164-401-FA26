import java.util.ArrayList;
import java.util.Scanner;

class September {
    public static void main(String[] args) {
        String[] params = {};
        October.main(params);
    }
}

public class October {
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2);

        // we need to tell the class "ArrayList"
        // what kinds of things we will store in it
        // it's a class parameter
        // that's what goes in <>

        ArrayList<String> names = new ArrayList<>();
        names.add("Justin");
        names.add("Ngu");
        names.add("Max");
        names.add("Emma");

        // primitive types are not allowed in here
        // cannot do ArrayList<int>

        // use the wrapper class
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("All the program params were:");
        for (int i =0; i < args.length; i++) {
            System.out.println(args[i] + " ");
        }
        if (args[0].equals("Thanos")) {
            System.out.println("Call the avengers!");
        }

        Human h1 = new Human("Justin", 20);
        Human h2 = new Human("Emma", 20);

        System.out.println(Human.population);

        benjaminButtons(h1);
    }

    static void benjaminButtons(Human human) {
        human.ageBackwards();
    }
}
class Human {
    String name;
    int age;
    double height;

    static final String SPECIES = "Homo Sapien";
    static int population = 0;

    public Human(int age) {
        // this constructor exists
        // to create a human
        // with an age
        // and without a name
        this.name = "to be determined.";
        if (age < 0) {
            age = 0;
        } else {
            this.age = age;
        }
    }

    public Human(String name, int age) {
        // this constructor exists
        // to construct a human
        // with a name
        // and an age
        // oh wait.. i already have some code to construct a human
        // with an age
        this(age);  // constructor chaining
                    // similar to Human(age)
        this.name = name;
        population++;
        // this(age); <-- not allowed, must be first statement in constructor body
    }

    public Human(String name, int age, double height) {
        // you can chain multiple times
        this(name, age);
        this.height = height;
    }

    static void thanos() {
        population /= 2;
    }

    void ageBackwards() {
        age--;
    }

}
