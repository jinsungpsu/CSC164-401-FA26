public class Module03_Assignment {
    public static void main(String[] args) {
        /*
        parallel arrays are similar to 2d arrays
        meaning, in index 0... there's multiple pieces of info
        but those pieces of info are spread out across multiple arrays
        and are tied together by the index...
         */

        String[] foodNames = {"Burger", "Salad", "Pizza", "Soup", "Pasta"};
        double[] foodPrices = {5.99, 4.49, 8.99, 3.99, 7.49};
        String[] foodAllergens = {"Gluten, Dairy", "Nuts", "Gluten, Dairy", "None", "Gluten, Dairy"};

        // where's all the info for a pizza?  is index 2
        System.out.printf("The %s costs $%.2f and has the following allergens: %s", foodNames[2], foodPrices[2], foodAllergens[2]);

        int indexForPizza = 2;
        System.out.printf("The %s costs $%.2f and has the following allergens: %s", foodNames[indexForPizza], foodPrices[indexForPizza], foodAllergens[indexForPizza]);

        // someone comes into my restaurant and orders burger and soup
        int[] orderedItems = {0,3};

        System.out.println("\n\n Itemized Invoice\nThis is what you ordered: ");
        for (int i = 0; i < orderedItems.length; i++) {
            int orderedItemIndex = orderedItems[i];
            System.out.printf("\nThe %s costs $%.2f and has the following allergens: %s", foodNames[orderedItemIndex], foodPrices[orderedItemIndex], foodAllergens[orderedItemIndex]);
        }
    }
}
