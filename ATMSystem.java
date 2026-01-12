package M4_activity2;


public class ATMSystem {

    // Array of account balances
    private static double[] accounts = {10000, 15000, 20000};

    // Method to process withdrawal
    public static void processWithdrawal(String accountIndex, String amountInput) {
        try {
            // Parse account index
            int index = Integer.parseInt(accountIndex);

            // Get current balance
            double balance = accounts[index];

            // Parse withdrawal amount
            double amount = Double.parseDouble(amountInput);

            // Display current details
            System.out.println("Account=" + accountIndex + ", Amount=" + amount);
            System.out.println("Current balance: " + balance);
            System.out.println("Withdrawal: " + amount);

            // Check funds
            if (amount > balance) {
                System.out.println("Insufficient funds! Cannot withdraw " + amount);
            } else {
                double newBalance = balance - amount;
                accounts[index] = newBalance;
                System.out.println("New balance: " + newBalance);
                System.out.println("Withdrawal successful!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid input!");
            System.out.println("Please enter valid numbers.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Account not found!");
            System.out.println("Invalid account index.");
        } catch (Exception e) {
            System.out.println("Transaction failed");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== ATM Withdrawal System ===\n");

        System.out.println("--- Test 1: Valid Withdrawal ---");
        processWithdrawal("0", "5000");

        System.out.println("--- Test 2: Invalid Account Index ---");
        processWithdrawal("abc", "5000");

        System.out.println("--- Test 3: Account Not Found ---");
        processWithdrawal("10", "5000");

        System.out.println("--- Test 4: Insufficient Funds ---");
        processWithdrawal("1", "20000");

        System.out.println("=== All tests completed! ===");
    }
}
