public class KindleReader2 {
    private int totalPages;
    private int currentPage;

    // Constructor
    public KindleReader2(int totalPages) {
        this.totalPages = totalPages;
        this.currentPage = 1;  // Starting at the first page
    }

    // Method to increment the current page by 1
    public void turnPages() {
        turnPages(1);  // Overloaded method to handle no argument case
    }

    // Overloaded method to increment the current page by a specified amount
    public void turnPages(int pagesToTurn) {
        if (currentPage + pagesToTurn > totalPages) {
            System.out.print("You were on                : ");
            System.out.println(this);
            System.out.println("Turning " + pagesToTurn + " pages would take you past the last page.");
            currentPage = totalPages;  // Set to last page
            System.out.print("You are now on             : ");
            System.out.println(this);
        } else {
            currentPage += pagesToTurn;
        }
    }

    // toString method to print the current state of the object
    @Override
    public String toString() {
        return String.format("Page %3d of %3d.", currentPage, totalPages);
    }
}

