/**
 * notes for next review:

 * program should be able to receive 0 to 255 in binary and decimal
 * make sure the program loops (ex. if user enters invalid input, if they wanted to run program again)
 *
 */

import java.util.Scanner;
public class BinaryNumSystem {
    public static void main(String[] args) {

        System.out.println("""
                --------------------------------------------------------------------
                | binary number system                                             |
                | a program that acts as a simple binary representation of numbers.|
                |                                                                  |
                | to convert a number from binary to decimal, enter 'b'            |
                | to convert a decimal number from decimal to binary, enter 'd'    |
                |                                                                  |
                | you can enter a number between 0 and 255.                        |
                --------------------------------------------------------------------
                """);

        //THIS SHOULD BE A LOOP
        System.out.print("""
                \n
                MENU
                ----
                converting binary to decimal? enter 'd'
                converting decimal to binary? enter 'b'
                
                exiting the program? enter any other key.
                -----------------------------------------
                
                your choice:  
                """);

        Scanner in = new Scanner(System.in);
        String userChoice = in.next();

        if (userChoice.equals("b")) {
            System.out.println(""" 
                    don't be confused by the use of 'decimal'! 
                    that's just the number system. input must be a whole number. 
                    
                    enter decimal number: """);

            //check if user inputs a valid integer


            /**
             * loop question above if user enters a non-whole number
             **/

            while(!in.hasNextInt()) {
                System.out.println("invalid input! be sure that your input is a whole number. try again: ");
                in.next(); // captures invalid input
            }


            //user's decimal input captured to be converted to binary
            //put check in place that assures user's input does not exceed 255

            int userDec = in.nextInt();

            if(userDec >= 255) {
                System.out.println("invalid input! you've entered a number greater than 255. try again: ");
            } else {

            decToBinary(userDec);
            }
        } else if (userChoice.equals("d")) {
            System.out.println("enter a binary number (in 8 bit, don't drop leading zeros");
            String userBin = in.next();

            binToDecimal(userBin);



        } else {
            System.out.println("exiting the program....");
        }

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
     */
    public static void decToBinary(int userDec) {
        //not permanent, practicing out the logic

        int decimal = userDec;
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

       }
        System.out.print(binValue + "\n\n");

    }

    /**
     * the gist of how binary is converted to decimal is...
     * we will parse (go through) the decimal value
     * for each place, we will multiply it by 2^position
     * note: we start from the last place to the first, and we start with 2^0
     */


    public static void binToDecimal(String userBin) {
        int binary = 11001; // 25 in decimal, we'll eventually want to write this as 00011001.

        /**
         * scratch previous notes, to parse we may have to store the number in an array right away
         */

        //25 in decimal
        String binNum = userBin;

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
        int bConv = 0; //declare and initalize BEFORE loop

        for (int loc = size - 1; loc >= 0; loc--) {
            //substring - takes one letter
            String numString = binNum.substring(loc, loc + 1);
            int bNum = Integer.parseInt(numString);

            array[loc] = bNum;
           System.out.println(loc + "\t" + array[loc]);

          if(bNum == 1) {
                //converted binary number
               bConv += (int) (bNum * Math.pow(2, (size - 1 - loc)));
            }
        }
    System.out.println(bConv);

    }

}
