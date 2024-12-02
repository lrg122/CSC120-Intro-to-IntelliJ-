import java.io.Serializable;
/**
 * Represents a boat in a fleet with specific attributes like type, name, make/model, and price.
 */
public class Boat implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * Enum representing the type of boat.
     */
    public enum BoatType { SAILING, POWER }
    private BoatType type;
    private String name;
    private int yearManufactured;
    private String makeModel;
    private double lengthInFeet; // Max 100
    private double purchasePrice; // Max 1,000,000
    private double maintenanceExpense;
    /**
     * Constructs a Boat with specified attributes.
     *
     * @param type            The type of the boat (SAILING or POWER).
     * @param name            The name of the boat.
     * @param yearManufactured The year the boat was manufactured.
     * @param makeModel       The make and model of the boat.
     * @param lengthInFeet    The length of the boat in feet (max 100).
     * @param purchasePrice   The purchase price of the boat (max 1,000,000).
     */

    public Boat(BoatType type, String name, int yearManufactured, String makeModel, double lengthInFeet, double purchasePrice) {
        this.type = type;
        this.name = name;
        this.yearManufactured = yearManufactured;
        this.makeModel = makeModel;
        this.lengthInFeet = lengthInFeet;
        this.purchasePrice = purchasePrice;
        this.maintenanceExpense = 0;
    }

    /**
     * Gets the type of the boat.
     *
     * @return The type of the boat as a string.
     */
    public String getType() {
        return type.name();
    } // end of getType method

    /**
     * Gets the name of the boat.
     *
     * @return The name of the boat.
     */
    public String getName() {
        return name;
    } // end of getName method

    /**
     * Gets the year the boat was manufactured.
     *
     * @return The manufacturing year.
     */
    public int getYearManufactured() {
        return yearManufactured;
    } // end of getYearManufactured method

    /**
     * Gets the make and model of the boat.
     *
     * @return The make and model of the boat.
     */
    public String getMakeModel() {
        return makeModel;
    } // end of getMakeModel method

    /**
     * Gets the length of the boat in feet.
     *
     * @return The length of the boat.
     */
    public double getLengthInFeet() {
        return lengthInFeet;
    } // end of getLengthInFeet method

    /**
     * Checks if a given amount can be spent on maintenance.
     *
     * @param amount The amount to be spent.
     * @return True if the amount can be spent; false otherwise.
     */
    public boolean canSpend(double amount) {
        return (maintenanceExpense + amount) <= purchasePrice;
    } // end of canSpend method


    /**
     * Adds an expense to the boat's maintenance record.
     *
     * @param amount The amount to be added.
     * @throws IllegalArgumentException if the expense exceeds the purchase price.
     */
    public void addExpense(double amount) {
        if (canSpend(amount)) {
            maintenanceExpense += amount;
        } else {
            throw new IllegalArgumentException("Expense exceeds limit.");
        }
    } // end of addExpense method


    /**
     * Gets the purchase price of the boat.
     *
     * @return The purchase price.
     */
    public double getPurchasePrice() {
        return purchasePrice;
    } // end of getPurchasePrice method


    /**
     * Gets the total maintenance expense of the boat.
     *
     * @return The maintenance expense.
     */
    public double getMaintenanceExpense() {
        return maintenanceExpense;
    } //end of getMaintenanceExpense method


} // end of Boat class

