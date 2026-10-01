import java.nio.charset.StandardCharsets;

public class JavaClasses {
    public static void main(String[] args) {
        String firstName = "Max";
        String anotherName = "Max";

        if (firstName == anotherName) {
            System.out.println("== did work in this case!");
        }
        // this looks like a primitive

        firstName = "emma";

        String lastName = new String("emma");
        // String is a class!!!
        // capital letter S tells you (assuming good naming convention)

        //System.out.println(firstName.contains("mm"));

        if (firstName == lastName) {
            System.out.println("first name is == to last name");
        }

        if (firstName.equals(lastName)) {
            System.out.println("first name equals using the method");
        }

    }
}
