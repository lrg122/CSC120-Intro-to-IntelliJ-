import java.util.Scanner;

public class DiveData {
    private static final Scanner keyboard = new Scanner(System.in);

    // Constant Variables

    private static final int FEET_PER_ATMOSPHERE = 33;
    private static final double MAX_O2_PRESSURE = 1.4;
    private static final double CONTINGENCY_O2_PRESSURE = 1.6;

    public static void main(String[] args) {

        // Create Variables
        double depth;
        int oxygenPercent;
        double ambientPressure;
        double partialPressureO2;
        boolean exceedsMaxPressure;
        boolean exceedsContingencyPressure;
        char o2Group;


        // Get input for variables
        System.out.print("Enter depth and percentage O2:");
        depth = keyboard.nextDouble();
        oxygenPercent = keyboard.nextInt();

        //Compute
        ambientPressure = depth / FEET_PER_ATMOSPHERE + 1;
        partialPressureO2 = ambientPressure * (double) oxygenPercent / 100;

        if (partialPressureO2 > MAX_O2_PRESSURE) {
            exceedsMaxPressure = true; }
        else {
            exceedsMaxPressure = false; }


        if (partialPressureO2 > CONTINGENCY_O2_PRESSURE) {
            exceedsContingencyPressure = true; }
        else {
            exceedsContingencyPressure = false; }

        o2Group = (char) ((int) (partialPressureO2 * 10) + (int) ('A'));

        // Output
        System.out.println("Ambient pressure: " + ambientPressure);
        System.out.println("O2 pressure: " + partialPressureO2);
        System.out.println("O2 group: " + o2Group);
        System.out.println("Exceeds maximal O2 pressure: " +exceedsMaxPressure);
        System.out.println("Exceeds contingency O2 pressure: " + exceedsContingencyPressure);





        } // end of main method



    } // end of DiveData class






