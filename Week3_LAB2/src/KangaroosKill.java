import java.util.Scanner;
public class KangaroosKill {

    private static final Scanner keyboard = new Scanner(System.in);

    // CONSTANT variables
    private static final double AVG_ROAD_WIDTH_KM = 0.01;
    private static final double ROADKILL_PROB_CONSTANT = 1.47;


    public static void main(String[] args) {
        // Variables to hold input & calculation values

        double sideLength;
        double roadLength;
        int numberOfKangaroos;

        double density;
        double surfaceArea;

        double expectedKills_Fraction;
        int expectedKills_Int;

        double injuries;
        int injuriesInt;

        // User Input
        System.out.print("Enter side of square in km: ");
        sideLength = keyboard.nextDouble();

        System.out.print("Enter roads length in km: ");
        roadLength = keyboard.nextDouble();

        System.out.print("Enter number of 'roos: ");
        numberOfKangaroos = keyboard.nextInt();

        // Calculate Density & Surface Area
        density = numberOfKangaroos / (sideLength * sideLength);
        surfaceArea = roadLength * AVG_ROAD_WIDTH_KM;

        // Calculate number of expected kills
        expectedKills_Fraction = density * surfaceArea * ROADKILL_PROB_CONSTANT;
        expectedKills_Int = (int) expectedKills_Fraction;

        // Determine possibility of injury
        injuries = expectedKills_Fraction - expectedKills_Int;
        injuriesInt = (injuries > 0) ? 1: 0;

        // Output Results
        System.out.println("Expected number of kills: " + expectedKills_Int);
        System.out.println("Expected number of injuries: " + injuriesInt);


    }
}
