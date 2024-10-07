import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Kindle {
    private static final Scanner keyboard = new Scanner(System.in);

    private int numberOfPages;
    private int currentPage;


    public Kindle(){
        numberOfPages = 0;
        currentPage = 1;


    } // end of default constructor
    public Kindle(int theNumberOfPages){

        numberOfPages = theNumberOfPages;
        currentPage = 1;

    } // end of initialized constructor with 1 parameter

    public String toString() {

        return ("Page " + currentPage + " of " + numberOfPages);

    } // end of toString method

    public void turnPages(int pagesTurned) {
        if (currentPage + pagesTurned < numberOfPages) {
            currentPage = currentPage + pagesTurned;
        }
        else {
            System.out.println("You were on     :" + toString());
            System.out.println("Turning " + pagesTurned + " pages would take you to the last page.");
            System.out.println("You are now on: Page " + numberOfPages + " of " + numberOfPages);
        }


    } // end of TurnPages method with 1 parameter

    public void turnPages() {

        turnPages(1);

    } // end of turnPages method with no parameters




} // end of Kindle class
