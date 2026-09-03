public class Module03_Lab {
    public static void main(String[] args) {
        int soldCarsJanuary= 10;
        int soldCarsFebruary = 11;
        int soldCarsMarch = 9;

        int[] soldCarsEachMonth = new int[12];

        // soldCarsEachMonth holds an address in memory
        // the [0] tells me do not move from that
        // address, the item i'm interested in
        // is right at the "beginning" of that memory
        // block
        soldCarsEachMonth[0] = 10;

        // the [1] tells me to move over 1 spot
        // so that is the second spot of memory
        // in this block (the memory allocated
        // for this array
        soldCarsEachMonth[1] = 11;
        soldCarsEachMonth[2] = 9;
        soldCarsEachMonth[3] = 14;
        soldCarsEachMonth[4] = 7;
        soldCarsEachMonth[5] = 18;
        soldCarsEachMonth[6] = 12;
        soldCarsEachMonth[7] = 5;
        soldCarsEachMonth[8] = 16;
        soldCarsEachMonth[9] = 8;
        soldCarsEachMonth[10] = 20;
        soldCarsEachMonth[11] = 13;

        String[] months = {
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"
        };

        System.out.println(months[11]); // print 12th item
        System.out.println(months[months.length - 1]); // print the last item

        for (int i = 0; i < 12; i++) {
            System.out.println(months[i] + "'s sales were: " + soldCarsEachMonth[i]);
        }

        // even better!  works generally for
        // any array
        // no matter how big
        for (int i = 0; i < months.length; i++) {
            System.out.println(months[i]);
        }

        // for each... is a little bit more readable
        // but only works when a counter is not needed
        for (String month: months) {
            System.out.println(month);
        }


        /* 2d array example */
        // now we have 12 months
        // 4 car salespersons
        int[][] soldCars = {
                {14, 16, 15, 12, 18, 17, 13, 15, 14, 19, 16, 15}, // Salesperson 1
                {11, 15, 17, 14, 13, 16, 18, 15, 12, 20, 14, 16}, // Salesperson 2
                {15, 13, 16, 19, 14, 15, 12, 17, 16, 14, 18, 15}, // Salesperson 3
                {17, 14, 15, 13, 16, 12, 19, 15, 14, 16, 11, 18}  // Salesperson 4
        };

        int[][] soldCars2 = {
                {14, 11, 15, 17}, // January
                {16, 15, 13, 14}, // February
                {15, 17, 16, 15}, // March
                {12, 14, 19, 13}, // April
                {18, 13, 14, 16}, // May
                {17, 16, 15, 12}, // June
                {13, 18, 12, 19}, // July
                {15, 15, 17, 15}, // August
                {14, 12, 16, 14}, // September
                {19, 20, 14, 16}, // October
                {16, 14, 18, 11}, // November
                {15, 16, 15, 18}  // December
        };

        int[][][] soldCars3 = { // premium or economy cars
                { {10,4}, {8,3}, {11,4}, {12,5} }, // January
                { {11,5}, {10,5}, {9,4}, {11,3} }, // February
                { {10,5}, {12,5}, {11,5}, {10,5} }, // March
                { {8,4}, {10,4}, {14,5}, {9,4} }, // April
                { {13,5}, {9,4}, {10,4}, {12,4} }, // May
                { {12,5}, {11,5}, {10,5}, {8,4} }, // June
                { {9,4}, {13,5}, {8,4}, {14,5} }, // July
                { {10,5}, {11,4}, {12,5}, {10,5} }, // August
                { {10,4}, {8,4}, {12,4}, {9,5} }, // September
                { {14,5}, {15,5}, {10,4}, {11,5} }, // October
                { {11,5}, {10,4}, {13,5}, {8,3} }, // November
                { {10,5}, {11,5}, {10,5}, {13,5} }  // December
        };

        // dimension 1 is month
        // dimension 2 is sales person
        // dimension 3 is premium vs economy car sold

        // dimension 1 is 12
        // dimension 2 is 4 (0 = Ngu, 1 = max, 2 = justin, 3 = emma)
        // dimension 3 is type of car sold (0 = premium, 1 = economy)

        // how many premium cars did justin sell in march?
        System.out.println("In March, Justin sold " + soldCars3[2][2][0]);

        // nonsense! int length = soldCars3[2][2][0].length;

        int[] numbersExample = {1,2,3,4,5,6,7};
        // can i insert 99 between 4 and 5?
        // i want the resulting array to have
        // {1,2,3,4,99,5,6} 7 gets pushed out or deleted

        // 2 step problem...
        // first step = create a space to insert...
        //    how?  shift elements
        // second step = actually insert the value

    }
}
