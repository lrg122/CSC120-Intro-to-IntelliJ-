import java.util.Scanner;
/**
 * The main application for managing a fleet of boats with a menu.
 */
public class FleetApp {
    private static final Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        FleetManager manager = new FleetManager();


        try {
            if (args.length > 0) {
                manager.loadFleet(args[0]);
            } else {
                manager.loadFleet(null);
            }
        } catch (Exception e) {
            System.err.println("Error loading fleet: " + e.getMessage());
        }

        System.out.println("Welcome to the Fleet Management System");
        System.out.println("--------------------------------------");

        boolean exit = false;
        while (!exit) {
            System.out.print("(P)rint, (A)dd, (R)emove, (E)xpense, e(X)it : ");
            String option = keyboard.nextLine().trim().toUpperCase();
            try {
                switch (option) {
                    case "P":
                        manager.printFleet();
                        break;
                    case "A":
                        System.out.print("Please enter the new boat CSV data: ");
                        String csv = keyboard.nextLine();
                        String[] fields = csv.split(",");
                        Boat boat = new Boat(
                                Boat.BoatType.valueOf(fields[0].toUpperCase()),
                                fields[1],
                                Integer.parseInt(fields[2]),
                                fields[3],
                                Double.parseDouble(fields[4]),
                                Double.parseDouble(fields[5])
                        );
                        manager.addBoat(boat);
                        break;
                    case "R":
                        System.out.print("Which boat do you want to remove? ");
                        String name = keyboard.nextLine();
                        if (!manager.removeBoat(name)) {
                            System.out.println("Cannot find boat " + name);
                        }
                        break;
                    case "E":
                        System.out.print("Which boat do you want to spend on? ");
                        String expenseName = keyboard.nextLine();
                        Boat foundBoat = manager.findBoat(expenseName);
                        if (foundBoat == null) {
                            System.out.println("Cannot find boat " + expenseName);
                        } else {
                            System.out.print("How much do you want to spend? ");
                            double amount = Double.parseDouble(keyboard.nextLine());
                            if (foundBoat.canSpend(amount)) {
                                foundBoat.addExpense(amount);
                                System.out.println("Expense authorized, $" + amount + " spent.");
                            } else {
                                System.out.printf("Expense not permitted, only $%.2f left to spend.%n",
                                        foundBoat.getPurchasePrice() - foundBoat.getMaintenanceExpense());
                            }
                        }
                        break;
                    case "X":
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid menu option, try again.");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }

        try {
            manager.saveFleet();
        } catch (Exception e) {
            System.err.println("Error saving fleet: " + e.getMessage());
        }

        System.out.println("Exiting the Fleet Management System");
    }
}

