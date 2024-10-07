import java.util.Scanner;
public class CheckNumber {
    private static final Scanner keyboard = new Scanner(System.in);
        private static final int MAX_NUMBER = 10;
        private static final int STOP_VALUE = 0;

    public static void main(String[] args) {
        System.out.println("WEEK 6 - LAB 5");

        int[] giveArray = new int[MAX_NUMBER];
        int count = inputNumbers(giveArray);

        for (int i = 0; i < count; i++) {
            int num = giveArray[i];
            boolean isFibonacci = isFibonacciNumber(num);
            boolean isPrime = isPrimeNumber(num);

            System.out.print(num + "is");
        if (isFibonacci && isPrime){
        System.out.println("Fibonacci & Prime");
        }
        else if (isFibonacci && !(isPrime)) {
            System.out.println("Fibonacci & is not Prime");
        }
        else if (!(isFibonacci) && isPrime) {
            System.out.println(" Not Fibonacci & is Prime");
        }
        else {
            System.out.println(" Not Fibonacci & is not Prime");
        }



        } // end of the for loop





    } // end of main method

    private static int inputNumbers(int[] giveArray) {
        int input;
        int count = 0;

        System.out.print("Please enter numbers (0 to stop):");
        do {
            input = keyboard.nextInt();
            if( input > 0) {
                giveArray[count] = input;
                count = count + 1;

            }
        } while ( input != STOP_VALUE && input < MAX_NUMBER);

        return count;

    } // end of inputNumbers method

    private static boolean isFibonacciNumber(int number) {
        int current = 0;
        int previous = 1;
        int next;

        while (current < number) {
            next = current + previous;
            previous = current;
            current = next;
        }
        if( current == number) {
            return true;
    }
        else {
            return false;
        }

    } // end of isFibonacciNumber method





    /**
     *
     * @param number
     * @return
     */

    private static boolean isPrimeNumber (int number) {

            int divisor = 2;

            while (divisor <= Math.sqrt(number)) {
                if (number % divisor == 0) {

                    return(false);
                }
                divisor++;
            }
            return(true);

    } //end of isPrimeNumber method




} // end of CheckNumber class
