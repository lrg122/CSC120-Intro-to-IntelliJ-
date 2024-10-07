import java.sql.SQLOutput;
import java.util.Scanner;
public class DurbanStreet {
    private static final Scanner keyboard = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("WEEK 7 - LAB 6");

        System.out.print("How many houses in the street? : ");
        int numberHouses = keyboard.nextInt();
        int[] houseNumbers = new int[numberHouses];


        int index = 0;

        for(index = 0; index < houseNumbers.length;index++){

            System.out.print("What is the next house number?: ");
            houseNumbers[index] = keyboard.nextInt();

        } // end of for loop

        int[][] peopleAges = new int[numberHouses][];
        int rowIndex;
        int colIndex;

        for(rowIndex = 0; rowIndex < peopleAges.length; rowIndex++) {

            System.out.print("How many people live in number " + houseNumbers[rowIndex] + ":");
            int numPeople = keyboard.nextInt();
            peopleAges[rowIndex] = new int[numPeople];

            for(colIndex = 0; colIndex < peopleAges[rowIndex].length; colIndex++) {

                System.out.print("What is the age of person " + (colIndex + 1)+ ":");
                peopleAges[rowIndex][colIndex] = keyboard.nextInt();

            } // end of the inner for loop COLUMN
        } // end of outer for loop ROW

        // COUNT

        int totalStreetAge = 0;
        for(rowIndex = 0; rowIndex < peopleAges.length; rowIndex++) {
            int totalAge = 0;


            for(colIndex = 0; colIndex < peopleAges[rowIndex].length; colIndex++) {

                totalAge = totalAge + peopleAges[rowIndex][colIndex];

            } // end of the inner for loop COLUMN

            System.out.println("House " + houseNumbers[rowIndex] + " has a total age of " + totalAge);
            totalStreetAge = totalStreetAge + totalAge;

        } // end of outer for loop ROW

        System.out.println("The street has a total age of " + totalStreetAge);





    } // end of main method



} // end of DurbanStreet class
