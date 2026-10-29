class Animal {

    // Parent (superclass) version of speak()
    void speak() {                     // Option A
        System.out.println("Animal sound");
    }

    // Parent version of walk()
    void walk() {
        System.out.println("Animal walking");
    }
}

class Bird extends Animal {

    // OVERRIDING:
    // Bird provides its own version of speak().
    // When called on a Bird object, this version is used instead
    // of the Animal version.
    @Override
    void speak() {                     // Option B
        System.out.println("Bird sound");
    }

    // Another overridden method.
    @Override
    void walk() {
        System.out.println("Bird walking");
    }

    // This method exists ONLY in Bird.
    void fly() {
        System.out.println("Bird flying");
    }
}

public class Main {

    public static void main(String[] args) {

        // --------------------------------------------------
        // Example 1: Regular Animal object
        // --------------------------------------------------
        Animal a = new Animal();

        // a refers to an Animal object,
        // so Animal's version of speak() runs.
        a.speak();                     // Option A


        // --------------------------------------------------
        // Example 2: Regular Bird object
        // --------------------------------------------------
        Bird b = new Bird();

        // b refers to a Bird object,
        // so Bird's overridden version runs.
        b.speak();                     // Option B

        // Bird can also access Bird-only methods.
        b.fly();


        // --------------------------------------------------
        // Example 3: Polymorphism
        // --------------------------------------------------

        // Reference Type = Animal
        // Object Type    = Bird
        Animal c = new Bird();

        // POLYMORPHISM:
        // Even though c is an Animal reference,
        // the actual object is a Bird.
        // Java checks the OBJECT TYPE at runtime
        // and executes Bird's overridden method.
        c.speak();                     // Option B

        // Same idea here.
        c.walk();                      // Bird's walk()

        // This would NOT compile:
        // c.fly();
        //
        // Why?
        // The reference type is Animal, and Animal
        // does not contain a fly() method.

        // CASTING:
        // We tell Java that c is actually a Bird.
        ((Bird)c).fly();

    }
}
