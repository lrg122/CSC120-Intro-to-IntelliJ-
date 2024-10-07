import java.util.Scanner;
public class TaxProgram {
    private static final Scanner keyboard = new Scanner(System.in);
    private static final double STINKING_RICH = 500000;
    private static final double QUITE_RICH = 200000;
    private static final double MIAMI_POOR = 100000;
    private static final double AVERAGE = 50000;
    private static final double REALISTIC = 20000;
    private static final double HIGH_RATE = 0.25;
    private static final double MEDIUM_RATE = 0.1;
    private static final double LOW_RATE = 0.03;

    public static void main(String[] args) {

        System.out.println("WEEK 5 - LAB 4");

        double amount, income, deductions;
        double taxable, taxAmount;
        char taxGroupLetter;
        income = 0.0;
        deductions = 0.0;
        double taxableIncome;
        char TaxGroup;
        double taxOwed;


        do {
            System.out.print("Enter next amount:");
            amount = keyboard.nextDouble();
            if (amount > 0.0) {
                income = income + amount;
            } else {
                deductions = deductions - amount;
            }
        }
            while (amount != 0.0);


        taxableIncome = computeTaxableIncome(income, deductions);
        TaxGroup = chooseTaxGroup(taxableIncome);
        taxOwed = computeTax(taxableIncome,taxGroup);
        displayTaxInformation(income,deductions, taxableIncome, taxGroup, taxOwed);








    } // end of main method
    private static double  computeTaxableIncome(double income, double deductions) {
        double taxable;
       if (income >= deductions) {
           taxable =  income - deductions;
       }
       else {
           return 0.0; }
       return taxable;

    }// end of the computeTaxableIncome method

    private static char chooseTaxGroup(double taxable) {
            char taxGroupLetter;
        if ( taxable >= STINKING_RICH) {
            taxGroupLetter = 'S'; }
        else if (taxable >= QUITE_RICH) {
            taxGroupLetter = 'Q';}
        else if (taxable >= MIAMI_POOR) {
            taxGroupLetter = 'M';}
        else if (taxable >= AVERAGE) {
            taxGroupLetter = 'A';}
        else if (taxable >= REALISTIC) {
            taxGroupLetter = 'R';}
        else {
            taxGroupLetter = 'P'; }

        return taxGroupLetter;

    } //end of the chooseTaxGroup method

    private static double computeTax(double taxable, char taxGroupLetter) {
        double taxAmount;
        if (taxGroupLetter == 'S' || taxGroupLetter == 'Q'){
             taxAmount = taxable * HIGH_RATE;}
        else if (taxGroupLetter == 'M') {
            taxAmount = taxable * MEDIUM_RATE;}
        else if (taxGroupLetter == 'A' || taxGroupLetter == 'R'){
            taxAmount = taxable * LOW_RATE;}
        else if (taxGroupLetter == 'P'){
            taxAmount = 0.0;}
        else {
            taxAmount = 0.0;
            System.out.print("Error");}

        return taxAmount;

    } // end of the computeTax method

   private static void displayTaxInformation(double income, double deductions, double taxable, char taxGroupLetter, double taxAmount){
        System.out.println("Income= " + income);
        System.out.println("Deductions= " + deductions);
        System.out.println("Taxable Income= "+ taxable);
        System.out.println("Tax Group= "+ taxGroupLetter);
        System.out.println("Tax owed= " +taxAmount);

   } // end of displayTaxInformation method



    } //end of TaxProgram class
