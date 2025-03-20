/**
 * notes for next review/revision:

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

            int userDec;
            while (true) {
                System.out.println(""" 
                        don't be confused by the use of 'decimal'! 
                        that's just the number system. input must be a whole number. 
                        
                        enter decimal number: """);

                //check if user inputs a valid integer


                /**
                 * loop question above if user enters a non-whole number
                 **/

                if (!in.hasNextInt()) {
                    System.out.println("invalid input! be sure that your input is a whole number. try again: \n");
                    in.next(); // captures invalid input
                    continue;
                }


                //user's decimal input captured to be converted to binary
                //put check in place that assures user's input does not exceed 255

                userDec = in.nextInt();

                if (userDec < 0 || userDec > 255) {
                    System.out.println("invalid input! you've entered a number outside the range of 0-255. try again: ");
                } else {
                    break;
                }


            }
            decToBinary(userDec);
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

    /**
     * PUT INTO AN ARRAY TO PAD ZEROS (MAKE BINARY NUMBER INTO 8-BIT)
     * @param userDec
     */
    public static void decToBinary(int userDec) {
        //not permanent, practicing out the logic

        int decimal = userDec;
        System.out.println("\n\ndecimal form: " + decimal);

        String binValue = "";
        int remainder;

        // put into an array to pad zeros (make binary number into 8-bit)

       while (decimal > 0) {
               remainder = decimal % 2;
               binValue = remainder + binValue;
               decimal = decimal / 2;

       }
        /**
         *  possibly store this answer in an array AFTER, then add leading 0s in any empty spaces
         *  seperate digits and store into array, fill in remaining empty leading values of array with 0s
         *  we'll need to input the array digits backwards
         *  for loop??
         */


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

        //declare an array to hold 8 places in binary (8-bits, up to 255 in decimal)
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
        int bConv = 0; //declare and initalize BEFORE loop to be printed outside loop

        /**
         * put checks in place that assure only binary numbers are being inputted,
         */

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
