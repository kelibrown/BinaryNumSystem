public class BinaryNumSystem {
    public static void main(String[] args) {
        //25 in decimal
        String binNum = "00011001";

        /**
         * digit * 2^position
         *
         * 0*2^0  != 1, therefore we need to flip the order the loop parses in.
         * instead of parsing like: 0 1 2 3 4 5 6 7 ---> we want to parse like this: 7 6 5 4 3 2 1
         */

        //declare an array to hold 8 values
        int array[] = new int[8];

        /**
         * find length of string using .length method (embedded within java)
         */

        int size = binNum.length();

        /**
         * initialization, check, increment
         *
         * initialization, we subtract 1 from the size of the number (in array form),
         * in this case being 8, to retrieve the location of the array and assign it to loc(ation)
         * check, while loc is greater than 0, (while there's still locations avaliable)
         *increment, decrease number location to parse backwards.
         */

        for (int loc = size - 1; loc >= 0; loc--) {
            //substring - takes one letter
            String numString = binNum.substring(loc, loc + 1);
            int bNum = Integer.parseInt(numString);

            array[loc] = bNum;
            System.out.println(loc + "\t" + array[loc]);
        }

        decToBinary(binNum, array);
    }
    // data type tbd

    /**
     * notes

     * steps

     * 1. divide base 10 value by 2
     * 2. take note of remainders (are they present or not?)
     * 3. think of the answers to step 2 with the binary number system in mind. yes? 1. no? 0.
     * 4. make sure these bits are **concatenated (not added!) backwards.
     */

    public static void decToBinary(String binNum, int[] array) {
        //not permanent, practicing out the logic

        int decimal = 25;
        System.out.println("\n\ndecimal form: " + decimal);

        /**
         * try dropping and collecting the decimal by initializing 'decimal' as a double.
         * if 'decinal' is a double, we type cast it to an int and add a 1
         * not exact but i know where i'm going
         */

       while (decimal > 0) {
            decimal = decimal / 2;
            int remainder = decimal % 2;
           System.out.print(remainder);
           // System.out.println(decimal % 2);

            //sort of forgot how modulus works, we can test out some values to confirm my assumptions
            //System.out.println(5 % 2);
           // System.out.println(10 % 2);



            /*
            if (decimal % 2 == 0) {
                System.out.print(0);
            } else if(decimal % 2 == 1) {
                System.out.print(1);
                decimal = (int) decimal;
            }
            System.out.println(decimal);

             */
       }


    }
}
