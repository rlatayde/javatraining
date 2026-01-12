package m4_activity1;


public class BankAccount {

    public static String getAccountName(String accountNumber) {
        if ("ACC-001".equals(accountNumber)) {
            return "Juan Dela Cruz";
        } else if ("ACC-002".equals(accountNumber)) {
            return "Maria Santos";
        } else {
            return null;
        }
    }

    public static void testCase(String accountNumber) {
        System.out.println("\nLooking up account: " + accountNumber);

        try {
            // Call getAccountName and assign to variable name
            String name = getAccountName(accountNumber);

            // Convert name to uppercase 
            String upper = name.toUpperCase();

            // Print the uppercase name
            System.out.println("Account holder: " + upper);

        } catch (NullPointerException e) {
            // Catch NullPointerException
            System.out.println("Error: Account not found!");
        }
    }

    // main method
    public static void main(String[] args) {
        // Print a header message
        System.out.println("=== Bank Account Lookup ===");

        // Test a valid account
        testCase("ACC-001");

        // Test an invalid account (triggers exception)
        testCase("ACC-999");

        // Print a completion message
        System.out.println("\n=== Lookup Complete ===");
    }
}
