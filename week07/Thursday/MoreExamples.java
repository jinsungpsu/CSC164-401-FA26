package cheat;

class Paper {
    private String color;

    // requires outside data, aka, argument
    // they're all public
    // the name is set + name of variable
    // return type is void
    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

public class Module06ConstructorWithData {
    public static void main(String[] args) {
        System.out.println("\n\n######### Aquatic pet");
        AquaticPet aqpet = new AquaticPet();

        System.out.println("###### Object class methods #####");
        Object thing = new Object();
        System.out.println(thing.toString());
        Object thing2 = new Object();
        if (thing.equals(thing2)) {
            System.out.println("thing and thing2 are equal");
        }

        System.out.println("\n\n######### Pet");
        Pet pet = new Pet("Fido");

        System.out.println("\n\n######### Bird");
        Bird bird = new Bird();
        // Bird class doesn't really add anything different
        // from the Animal class
        // instead, we should be creating an Animal

        System.out.println("\n\n######### Animal");
        Animal animal = new Animal(99);

        System.out.println("\n\n######### Animal");
        Animal worm = new Animal(3);
        worm.setAge(1);

        pet.setAge(5);
        // methods are inherited
        // so we use setters from superclasses as needed

        Dinosaur trex = new Dinosaur();

        System.out.println("######################## worm & trex talking #### ");
        worm.talk();
        trex.talk();

        System.out.println("Worm data:");
        System.out.println(worm);

        System.out.println("T-Rex data:");
        System.out.println(trex);

        Food food = new Food();
        System.out.println(food);

        AquaticPet goldfish = new AquaticPet();

        doSomethingFun(worm);
        doSomethingFun(trex);
        doSomethingFun(goldfish);
    }

    static void doSomethingFun(Animal animal) {
        System.out.println("We're having fun!");
        for (int i = 0; i < 5; i++) {
            animal.talk();
        }
    }
}

class Food {
    private String name;
}

class Animal {
    // Animal class is the superclass
    private String species;
    private String family;
    private int age;

    public Animal(int age) {
        species = "unknown";
        family = "uknown";
        this.age = age;
        System.out.println("Animal was born!  No species or family assigned.");
    }

    public void setAge(int age) {
        if (age < 0) {
            this.age = 0;
            return;
        }
        this.age = age;
    }

    public void talk() {
        System.out.println("making an animal sound... not sure...");
    }

    @Override
    public String toString() {

        // does some stuff

        return "this is an animal!"
                + "\nage: " + age
                + "\nfamily: " + family
                + "\nspecies: " + species;
    }
}

class Dinosaur extends Animal {
    private boolean extinct;

    public Dinosaur() {
        super(-100);
    }

    public Dinosaur(int age) {
        super(age);
    }

    @Override           // optional
    public void talk() {
        System.out.println("ROAR!");
    }

    // @Override <-- this would cause a compiler error - can't run this program anymore
    // because eat is not in the superclass
    public void eat() {

    }

}

class Bird extends Animal {
    // not adding any additional
    // stuff in here... makes this class useless
    // you would just use the superclass instead

    public Bird() {
        super(0);
        System.out.println("A bird was born! A bird is an animal!");
    }

    public void talk() {
        System.out.println("Tweet tweet");
    }
}

class Pet extends Animal {
    // Cat class extends or inherits from
    // class Animal
    private String name;
    //private int age;
    public Pet(String name) {
        super(0);
        this.name = name;
        System.out.println("A pet is born!  Let's set a name: " + name);
    }


}

class AquaticPet extends Pet {
    private boolean saltWater;

    public AquaticPet() {
        // implict call to the super class constructors
        super("A nameless pet I just got from the pond"); // this is usually implict.. making it explicit
        saltWater = true;
        System.out.println("A saltwater aquatic pet is born!");
    }

    public void talk() {
        System.out.println("glug glug");
    }
}
