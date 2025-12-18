package m3_activity3;


import java.util.*;

public class MapProductApp {

    public static void main(String[] args) {
        Map<String, Integer> products = new LinkedHashMap<>();

        // Initial 5 records
        products.put("Laptop", 35000);
        products.put("Mouse", 500);
        products.put("Keyboard", 1200);
        products.put("Monitor", 8000);
        products.put("Printer", 6000);

        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        while (keepRunning) {
            printMenu();
            System.out.print("Select an option (1-5): ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    searchProduct(products, scanner);
                    break;
                case "2":
                    addProduct(products, scanner); // No validation
                    break;
                case "3":
                    printAll(products);
                    break;
                case "4":
                    findCheapest(products);
                    break;
                case "5":
                    keepRunning = false;
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1–5.\n");
            }
        }

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n===== Product Menu =====");
        System.out.println("1. Search a product");
        System.out.println("2. Add a product");
        System.out.println("3. Print all products and prices");
        System.out.println("4. Find the cheapest product");
        System.out.println("5. Exit");
        System.out.println("========================");
    }

    private static void searchProduct(Map<String, Integer> products, Scanner scanner) {
        System.out.print("Enter product name to search: ");
        String query = scanner.nextLine().trim();

        String foundKey = findExistingKey(products, query);
        if (foundKey != null) {
            System.out.println("Found: " + foundKey + " → " + products.get(foundKey) + "\n");
        } else {
            System.out.println("Product '" + query + "' not found.\n");
        }
    }

    /** Add product  */
    private static void addProduct(Map<String, Integer> products, Scanner scanner) {
        System.out.print("Enter new product name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter price (integer): ");
        int price = scanner.nextInt();
        scanner.nextLine(); // consume newline

        products.put(name, price);
        System.out.println("Added '" + name + "' → " + price + "\n");
    }

    private static void printAll(Map<String, Integer> products) {

        System.out.println("\n--- Product List ---");
        for (Map.Entry<String, Integer> entry : products.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
        System.out.println("Total products: " + products.size() + "\n");
    }

    private static void findCheapest(Map<String, Integer> products) {

        Map.Entry<String, Integer> cheapest = Collections.min(
                products.entrySet(),
                Comparator.comparingInt(Map.Entry::getValue)
        );

        System.out.println("Cheapest: " + cheapest.getKey() + " → " + cheapest.getValue() + "\n");
    }

    private static String findExistingKey(Map<String, Integer> products, String name) {
        for (String key : products.keySet()) {
            if (key.equalsIgnoreCase(name)) {
                return key;
            }
        }
        return null;
    }
}