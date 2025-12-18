package M3_activity2;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class ProductSetApp {
    public static void main(String[] args) {
        // Step 1: Create HashSet with 5 initial products
        HashSet<String> products = new HashSet<>(Arrays.asList("Laptop","Smartphone","Tablet","Keyboard","Webcam"));
		/*
		 * products.add("Laptop"); products.add("Smartphone"); products.add("Tablet");
		 * products.add("Keyboard"); products.add("Webcam");
		 */
        Scanner sc = new Scanner(System.in);
        int choice;

        // Step 2: Display menu repeatedly until exit
        do {
            System.out.println("\nSelect an option:");
            System.out.println("1. Search a product");
            System.out.println("2. Add a product");
            System.out.println("3. Print all products and count");
            System.out.println("4. Exit");
            System.out.print("Enter your choice [1 - 4]: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product to search: ");
                    String searchProduct = sc.nextLine();
                    if (products.contains(searchProduct)) {
                        System.out.println(searchProduct + " is available.");
                    } else {
                        System.out.println(searchProduct + " not found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter product to add: ");
                    String newProduct = sc.nextLine();
                    if (products.add(newProduct)) {
                        System.out.println(newProduct + " added successfully.");
                    } else {
                        System.out.println(newProduct + " already exists.");
                    }
                    break;

                case 3:
                    System.out.println("All Products: ");
                    for (String Products : products) {
                    	System.out.println(Products);
                    }
					System.out.println("Total count: " + products.size());
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}