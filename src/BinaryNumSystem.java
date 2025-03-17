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
         * why do we need to find the length?
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

    /**
     * steps have changed a bit. write appropriate comment here.
     * @param binNum
     * @param array
     */
    public static void decToBinary(String binNum, int[] array) {
        //not permanent, practicing out the logic

        int decimal = 25;
        System.out.println("\n\ndecimal form: " + decimal);

        /**
         * try dropping and collecting the decimal by initializing 'decimal' as a double.
         * if 'decinal' is a double, we type cast it to an int and add a 1
         * not exact but i think i know where i'm going
         */

        String binValue = "";
        int remainder;


       while (decimal > 0) {
               remainder = decimal % 2;
               binValue = remainder + binValue;
               decimal = decimal / 2;

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
        System.out.print(binValue);

    }

    /**
     * the gist of how binary is converted to decimal is...
     * we will parse (go through) the decimal value
     * for each place, we will multiply it by 2^position
     * note: we start from the last place to the first, and we start with 2^0
     */

    /**
     * don't worry about user input or storing the right amount of value places just yet
     */

    public static void BinToDecimal() {
        int binary = 11001; // 25 in decimal, we'll eventually want to write this as 00011001.

        /**
         * scratch previous notes, to parse we may have to store the number in an array right away
         */



    }

    public static int[] intToArray(int binary) {
        int[] array = new int[8];
        // if array location is empty enter zero?




    }

}
