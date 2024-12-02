import java.io.*;
import java.util.ArrayList;
/**
 * Manages a fleet of boats by loading, saving, adding, removing, and retrieving boats.
 */
public class FleetManager {
    private ArrayList<Boat> fleet;


    /**
     * Constructs a FleetManager with an empty fleet.
     */
    public FleetManager() {
        fleet = new ArrayList<>();
    }


    /**
     * Loads the fleet data from a file.
     *
     * @param filePath The path to the file containing fleet data.
     * @throws IOException            If there is an issue reading the file.
     * @throws ClassNotFoundException If the data in the file cannot be deserialized.
     */
    public void loadFleet(String filePath) throws IOException, ClassNotFoundException {
        if (filePath == null) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("FleetData.db"))) {
                fleet = (ArrayList<Boat>) ois.readObject();
            } catch (FileNotFoundException e) {
                System.out.println("No existing fleet found. Starting fresh.");
            }
        } else { // Load from CSV
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    Boat boat = new Boat(
                            Boat.BoatType.valueOf(fields[0].toUpperCase()),
                            fields[1],
                            Integer.parseInt(fields[2]),
                            fields[3],
                            Double.parseDouble(fields[4]),
                            Double.parseDouble(fields[5])
                    );
                    fleet.add(boat);
                }
            }
        }
    }

    /**
     * Saves the fleet data to a file.
     *
     * @throws IOException If there is an issue writing to the file.
     */

    public void saveFleet() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FleetData.db"))) {
            oos.writeObject(fleet);
        }
    }


    /**
     * Adds a boat to the fleet.
     *
     * @param boat The boat to be added.
     */
    public void addBoat(Boat boat) {
        fleet.add(boat);
    }


    /**
     * Removes a boat from the fleet by its name.
     *
     * @param name The name of the boat to be removed.
     * @return True if the boat was removed; false otherwise.
     */
    public boolean removeBoat(String name) {
        return fleet.removeIf(b -> b.getName().equalsIgnoreCase(name));
    }


    /**
     * Finds a boat in the fleet by its name.
     *
     * @param name The name of the boat to find.
     * @return The boat, or null if not found.
     */
    public Boat findBoat(String name) {
        return fleet.stream()
                .filter(b -> b.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    /**
     * Calculates the total amount paid for all boats in the fleet.
     *
     * @return The total amount paid.
     */
    public double getTotalPaid() {
        return fleet.stream().mapToDouble(Boat::getPurchasePrice).sum();
    }

    /**
     * Calculates the total maintenance expenses for all boats in the fleet.
     *
     * @return The total maintenance expenses.
     */

    public double getTotalSpent() {
        return fleet.stream().mapToDouble(Boat::getMaintenanceExpense).sum();
    }

    /**
     * Prints the details of the fleet, including total amounts paid and spent.
     */

    public void printFleet() {
        System.out.println("Fleet report:");
        for (Boat boat : fleet) {
            System.out.printf("%-8s %-20s %4d %-10s %4.1f' : Paid $%10.2f : Spent $%10.2f%n",
                    boat.getType(), boat.getName(), boat.getYearManufactured(),
                    boat.getMakeModel(), boat.getLengthInFeet(),
                    boat.getPurchasePrice(), boat.getMaintenanceExpense());
        }
        System.out.printf("Total: Paid $%10.2f : Spent $%10.2f%n", getTotalPaid(), getTotalSpent());
    }

} // end of FleetManager class

