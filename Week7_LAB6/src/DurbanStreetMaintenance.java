import java.util.Scanner;
public class DurbanStreetMaintenance {
    private static final Scanner keyboard = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("WEEK 7 - LAB 6");
        System.out.print("How many houses in the street? : ");
        int numHouses = keyboard.nextInt();
        int[] houseNumbers = new int[numHouses];
        int[][] peopleAges = new int[numHouses][];


        houseData(houseNumbers, peopleAges);

        analyzeHouseData(houseNumbers, peopleAges);

    } // end of main method

    public static void houseData (int [] houseNumbers, int [][] peopleAges) {
        for (int i = 0; i < houseNumbers.length; i++) {

            System.out.print("What is the next house number?   : ");
            houseNumbers[i] = keyboard.nextInt();


            System.out.print("How many people live in number " + houseNumbers[i] + " : ");
            int numPeople = keyboard.nextInt();
            peopleAges[i] = new int[numPeople];


            for (int j = 0; j < numPeople; j++) {
                System.out.print("What is the age of person " + (j + 1) + "      : ");
                peopleAges[i][j] = keyboard.nextInt();
            }
        }

    } // end of houseData method

    public static void analyzeHouseData(int[] houseNumbers, int[][] peopleAges) {
        int totalStreetAge = 0;


        for (int i = 0; i < houseNumbers.length; i++) {
            int houseTotalAge = 0;
            for (int age : peopleAges[i]) {
                houseTotalAge += age;
            }

            System.out.println("House " + houseNumbers[i] + " has a total age of " + houseTotalAge);
            totalStreetAge += houseTotalAge;
        }

        System.out.println("The street has a total age of " + totalStreetAge);

    } //end of analyzeHouseData method





//    public static void houseData (int [] houseNumbers, int [][] peopleAges) {
//        int rowIndex;
//        int colIndex;
//        for ( rowIndex = 0; rowIndex < houseNumbers.length; rowIndex++) {
//
//            System.out.print("What is the next house number?: ");
//            houseNumbers[rowIndex] = keyboard.nextInt();
//
//
//            System.out.print("How many people live in number " + houseNumbers[rowIndex] + ":");
//            int numPeople = keyboard.nextInt();
//            peopleAges[rowIndex] = new int[numPeople];
//
//
//            for (colIndex = 0; colIndex < peopleAges[rowIndex].length; colIndex++) {
//                System.out.print("What is the age of person " + (colIndex)  + ":");
//                peopleAges[rowIndex][colIndex] = keyboard.nextInt();
//            }
//        }
//
//    } // end of houseData method





} // end of DurbanStreetMaintenance class
