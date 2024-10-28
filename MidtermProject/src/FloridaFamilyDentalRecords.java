import java.util.Scanner;
/**
 * FloridaFamilyDentalRecords is a program designed for the Florida Dental Association to welcome and assist families with teeth information.
 * This program records the types of teeth (incisors, bicuspids, missing) for each member of a family (max 6).
 * Program allows users to choose from printing their dental records, extracting a tooth, and calculating root canal indices.
 */
public class FloridaFamilyDentalRecords {

    private static final Scanner keyboard = new Scanner(System.in);

    static final int MAX_NUMBER_PEOPLE = 6;
    static final int MAX_NUMBER_TEETH = 8;
    static final char[] VALID_TEETH = {'I', 'B', 'M'};

    public static void main(String[] args) {
        System.out.println("Welcome to the Floridian Tooth Records\n--------------------------------------");

        int familySize = getFamilySize();
        String[] familyNames = getFamilyName(familySize);
        char[][][] teethData = new char[familySize][2][MAX_NUMBER_TEETH];

        getTeethRow(familyNames, teethData);
        displayMenu(familyNames, teethData);


    } // end of main method
    /**
     * Asks the user for the number of family members (max of 6).
     *
     * @return size of the family
     */

    private static int getFamilySize() {
        int sizeOfFamily;

        do {
            System.out.print("Please enter number of people in the family : ");
            sizeOfFamily = keyboard.nextInt();
            if (sizeOfFamily < 1 || sizeOfFamily > MAX_NUMBER_PEOPLE) {
                System.out.println("Invalid number of people, try again");
            }
        } while (sizeOfFamily < 1 || sizeOfFamily > MAX_NUMBER_PEOPLE);
        return sizeOfFamily;

    } // end of familySize method (Getter Method)
    /**
     * Gets each family member's name.
     *
     * @param sizeOfFamily the number of family members
     * @return an array of family member names
     */

    private static String[] getFamilyName(int sizeOfFamily) {
        int index;
        String[] familyNames = new String[sizeOfFamily];


        for (index = 0; index < sizeOfFamily; index++) {
            System.out.printf("Please enter the name for family member %d   : ", index + 1);
            familyNames[index] = keyboard.next();
        }
        return familyNames;

    } //end of familyName method (Getter Method)
    /**
     * Gets the teeth rows (uppers and lowers) for each family member.
     *
     * @param familyNames array of family member names
     * @param teethData   3D array to store each member's teeth data
     */

    private static void getTeethRow(String[] familyNames, char[][][] teethData) {
        int index;
        int row;
        for ( index =0; index < familyNames.length; index++) {
            for ( row = 0; row < 2; row++) {
                String rowType;


                if (row == 0) {
                    rowType = "uppers";
                } else {
                    rowType = "lowers";
                }

                char[] teethRow;
                do {
                    System.out.print("Please enter the " + rowType + " for " + familyNames[index] + ": ");
                    String input = keyboard.next();
                    teethRow = input.toUpperCase().toCharArray();

                    if (teethRow.length > MAX_NUMBER_TEETH || !isValidTeethRow(teethRow)) {
                        System.out.println("Invalid teeth types or too many teeth, try again.");
                    }
                } while (teethRow.length > MAX_NUMBER_TEETH || !isValidTeethRow(teethRow));

                teethData[index][row] = teethRow;
            }
        }
    } // end of getTeethRow method (Setter Method)
    /**
     * Validates a teeth row by checking that each character represents a valid tooth type.
     *
     * @param teethRow array of teeth characters
     * @return true if valid, false otherwise
     */

    private static boolean isValidTeethRow(char[] teethRow) {
        for (char tooth : teethRow) {
            boolean valid = false;
            for (char validTooth : VALID_TEETH) {
                if (tooth == validTooth) {
                    valid = true;
                    break;
                }
            }
            if (!valid) return false;
        }
        return true;
    } // end of isValidTeethRow method (Getter Method)
    /**
     * Displays the main menu and allows users to choose from printing, extracting, calculating, or exiting.
     *
     * @param familyNames array of family member names
     * @param teethData   3D array storing teeth data
     */

    private static void displayMenu(String[] familyNames, char[][][] teethData) {
        char option;

        while (true) {
            System.out.print("\n(P)rint, (E)xtract, (R)oot, e(X)it: ");
            option = keyboard.next().toUpperCase().charAt(0);


            // Validate input and call the appropriate method
            if (option == 'P') {
                printFamilyTeethRecord(familyNames, teethData);
            } else if (option == 'E') {
                extractTooth(familyNames, teethData);
            } else if (option == 'R') {
                calculateRootCanalIndices(familyNames,teethData);
            } else if (option == 'X') {
                System.out.println("Exiting the program. Goodbye!");
                break;
            } else {
                System.out.println("Invalid option, please try again.");
            }
        }
    } // end of displayMenu method (Setter Method)
    /**
     * Prints each family member's teeth record, displaying the uppers and lowers individually.
     *
     * @param familyNames array of family member names
     * @param teethData   3D array storing teeth data
     */

    private static void printFamilyTeethRecord(String[] familyNames, char[][][] teethData) {
        int index;
        int index2;
        for ( index = 0; index < familyNames.length; index++) {
            System.out.println(familyNames[index]);
            System.out.print("  Uppers: ");
            for (index2 = 0; index2 < teethData[index][0].length; index2++) {
                System.out.print((index2+1) + ":" + teethData[index][0][index2] + " ");
            }
            System.out.print("\n  Lowers: ");
            for ( index2 = 0; index2 < teethData[index][1].length; index2++) {
                System.out.print((index2+1) + ":" + teethData[index][1][index2] + " ");
            }
            System.out.println();
        }
    } // end of printFamilyTeethRecord method (Setter Method)
    /**
     * Allows the user to specify which family member's tooth needs to be extracted.
     *
     * @param familyNames array of family member names
     * @param teethData   3D array storing teeth data
     */

    private static void extractTooth(String[] familyNames, char[][][] teethData) {
        String memberName;
        int familyIndex = -1;


        while (familyIndex == -1) {
            System.out.print("Which family member: ");
            memberName = keyboard.next().trim();


            for (int i = 0; i < familyNames.length; i++) {
                if (familyNames[i].equalsIgnoreCase(memberName)) {
                    familyIndex = i;
                    break;
                }
            }

            if (familyIndex == -1) {
                System.out.println("Invalid family member, try again.");
            }
        }

        char layer;
        int rowIndex = -1;

        while (rowIndex == -1) {
            System.out.print("Which tooth layer (U)pper or (L)ower: ");
            layer = keyboard.next().toUpperCase().charAt(0);
            if (layer == 'U') {
                rowIndex = 0;
            } else if (layer == 'L') {
                rowIndex = 1;
            } else {
                System.out.println("Invalid layer, try again.");
            }
        }

        int toothIndex;
        while (true) {
            System.out.print("Which tooth number: ");
            toothIndex = keyboard.nextInt() - 1;  // Convert to 0-based index
            if (toothIndex < 0 || toothIndex >= MAX_NUMBER_TEETH) {
                System.out.println("Invalid tooth number, try again.");
            } else if (teethData[familyIndex][rowIndex][toothIndex] == 'M') {
                System.out.println("Missing tooth, try again.");
            } else {
                // Extract the tooth by setting it to 'M' (missing)
                teethData[familyIndex][rowIndex][toothIndex] = 'M';
                System.out.println("Tooth extracted.");
                break;
            }
        }
    } // end of extractTooth method (Setter method)
    /**
     * Calculates and displays root canal indices based on the family's tooth data.
     * The indices are the roots of the equation Ix^2 + Bx - M, where I, B, and M represent how many of each type of teeth.
     * @param teethData 3D array storing teeth data
     */

    private static void calculateRootCanalIndices(String[] familyNames, char[][][] teethData) {
        int incisors = 0, bicuspids = 0, missing = 0;

        for (char[][] personTeeth : teethData) {
            for (char[] row : personTeeth) {
                for (char tooth : row) {
                    if (tooth == 'I') incisors++;
                    else if (tooth == 'B') bicuspids++;
                    else if (tooth == 'M') missing++;
                }
            }
        }

        if (incisors == 0) {
            System.out.println("No root canal index calculation possible.");
            return;
        }


        double discriminant = Math.pow(bicuspids, 2) + 4 * incisors * missing;
        if (discriminant < 0) {
            System.out.println("No real roots found.");
        } else {
            double root1 = (-bicuspids + Math.sqrt(discriminant)) / (2 * incisors);
            double root2 = (-bicuspids - Math.sqrt(discriminant)) / (2 * incisors);
            System.out.printf("One root canal at %.2f\n", root1);
            System.out.printf("Another root canal at at %.2f\n", root2);
        }
    } // end of calculateRootCanalIndices method (Setter method)







} // end of FloridaFamilyDentalRecords class

