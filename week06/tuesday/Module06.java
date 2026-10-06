public class Module06 {
    public static void main(String[] args) {
        System.out.println("\n\n######### Aquatic pet");
        AquaticPet aqpet = new AquaticPet();

        System.out.println("\n\n######### Pet");
        Pet pet = new Pet();

        System.out.println("\n\n######### Bird");
        Bird bird = new Bird();
        // Bird class doesn't really add anything different
        // from the Animal class
        // instead, we should be creating an Animal

        System.out.println("\n\n######### Animal");
        Animal animal = new Animal();

        System.out.println("\n\n######### Animal");
        Animal worm = new Animal();
        worm.setAge(1);

        pet.setAge(5);
        // methods are inherited
        // so we use setters from superclasses as needed


    }
}

class Animal {
    // Animal class is the superclass
    private String species;
    private String family;
    private int age;

    public Animal() {
        species = "unknown";
        family = "uknown";
        age = 0;
        System.out.println("Animal was born!  No species or family assigned.");
    }

    public void setAge(int age) {
        if (age < 0) {
            this.age = 0;
            return;
        }
        this.age = age;
    }
}

class Dinosaur extends Animal {
    private boolean extinct;
}

class Bird extends Animal {
    // not adding any additional
    // stuff in here... makes this class useless
    // you would just use the superclass instead

    public Bird() {
        System.out.println("A bird was born! A bird is an animal!");
    }
}

class Pet extends Animal {
    // Cat class extends or inherits from
    // class Animal
    private String name;
    //private int age;

    public Pet() {
        name = "Dixie";
        System.out.println("A pet is born!  Let's set a name: " + name);
    }
}

class AquaticPet extends Pet {
    private boolean saltWater;

    public AquaticPet() {
        // implict call to the super class constructors
        super(); // this is usually implict.. making it explicit
        saltWater = true;
        System.out.println("A saltwater aquatic pet is born!");
    }
}
