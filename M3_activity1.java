package m3_activity1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductList {
    public static void main(String[] args) {
        // Create and populate the ArrayList
        List<String> ProductList = new ArrayList<>();
        ProductList.add("Laptop");
        ProductList.add("Mouse");
        ProductList.add("Keyboard");
        ProductList.add("Monitor");
        ProductList.add("Printer");


        System.out.println("All Product/s:");
        for (String Product : ProductList) {
        	System.out.println(Product);
        }

        ProductList.add("Webcam");
        ProductList.remove("Mouse");
        System.out.println("\nAfter Adding and Removing Product/s:");
        for (String Product : ProductList) {
        	System.out.println(Product);
        }

        
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Ask the user to search
        System.out.print("\nEnter a product name to search: ");
        while (true) {
            String query = scanner.nextLine().trim();


            // Case-insensitive search
            int foundIndex = -1;
            for (int i = 0; i < ProductList.size(); i++) {
                if (ProductList.get(i).equalsIgnoreCase(query)) {
                    foundIndex = i;
                    break;
                }
            }

            if (foundIndex != -1) {
                System.out.println("Product Found: " + ProductList.get(foundIndex));
            } else {
                System.out.println("Product Not found: " + query);
            }

        }
    }
}
