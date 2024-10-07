import java.util.Scanner;

//=============================================================================
public class GasLaw {
    //-----------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    //----The gas constant in Joules/mole/K
    private static final double GAS_CONSTANT = 8.3143;

    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

//----Variables to hold system values
        double volume;
        double moles;
        double temperature;
        double pressure;

//----Ask user to input data
        System.out.print("Enter volume, moles, temperature : ");
        volume = keyboard.nextDouble();
        moles = keyboard.nextDouble();
        temperature = keyboard.nextDouble();

//----Calculation equation
        pressure = moles * GAS_CONSTANT * temperature / volume;

//----Show result
        System.out.println("Pressure is " + pressure);
    }
}
//-----------------------------------------------------------------------------
//=============================================================================