import java.util.Scanner;

public class Practice {
    private static final Scanner keyboard = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("Practice Arrays");


        System.out.println("How many elements in array do you want?");
        int arraySize = keyboard.nextInt();

        int [] myArray = new int [arraySize];

        int [][] yourArray = new int [3][2];

        // update array

        int rowIndex;
        int colIndex;

        for(rowIndex = 0; rowIndex < yourArray.length; rowIndex++) {
            System.out.println();
            for(colIndex = 0; colIndex < yourArray[rowIndex].length; colIndex++) {

                System.out.println("At index [" + rowIndex + "] [" + colIndex + "] Enter a number:");
                yourArray[rowIndex][colIndex] = keyboard.nextInt();

            } // end of the inner for loop COLUMN
        } // end of outer for loop ROW

        // DISPLAY



        for(rowIndex = 0; rowIndex < yourArray.length; rowIndex++) {

            for(colIndex = 0; colIndex < yourArray[rowIndex].length; colIndex++) {

                System.out.println("At index [" + rowIndex + "] [" + colIndex + "] The value is: " + yourArray[rowIndex][colIndex]);


            } // end of the inner for loop COLUMN
        } // end of outer for loop ROW


//        // Declaring an array
//        int[] myArray = new int[4];
//
//        // Updating the array
//
//        int index;
//        for (index = 0; index < myArray.length; index++) {
//
//            System.out.print("At index [" + index + "], Enter a number:");
//            myArray[index] = keyboard.nextInt();
//        } // end of for loop
//
//        // Display array
//        for (index = 0; index < myArray.length; index++) {
//
//            System.out.println("At index [" + index + "], The value is: " + myArray[index]);
//        } // end of for loop


    } // end of main method

    private static void  updateMyArray (int [] myArray){

        // Updating the array

        int index;
        for (index = 0; index < myArray.length; index++) {

            System.out.print("At index [" + index + "], Enter a number:");
            myArray[index] = keyboard.nextInt();
        } // end of for loop

        // Display array
        for (index = 0; index < myArray.length; index++) {

            System.out.println("At index [" + index + "], The value is: " + myArray[index]);
        } // end of for loop



    } // end of updateMyArray



} // end of Practice class
