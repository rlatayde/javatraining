package m4_activity5;

// Validator Class
public class AccountValidator {

    public static void validateAccountNumber(String accountNumber) throws InvalidAccountNumberException {
        if (accountNumber == null) {
            throw new NullPointerException("Account number cannot be null");
        }
        if (!accountNumber.matches("\\d+")) {
            throw new InvalidAccountFormatException("Account number must contain only digits");
        }
        if (accountNumber.length() != 10) {
            throw new InvalidAccountNumberException("Account number must be exactly 10 digits");
        }
        System.out.println("Valid account number: " + accountNumber);
    }

    public static void testValidation(String testName, String accountNumber) {
        System.out.println(testName);
        try {
            validateAccountNumber(accountNumber);
            System.out.println();
        } catch (InvalidAccountNumberException | InvalidAccountFormatException | NullPointerException e) {
            System.out.println("Warning: " + e.getMessage());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Account Number Validation Test ===\n");
        testValidation("Test 1: Valid account (1234567890)", "1234567890");
        testValidation("Test 2: Too long (12345678901)", "12345678901");
        testValidation("Test 3: Contains letters (12345ABC90)", "12345ABC90");
        testValidation("Test 4: Contains space (1234 567890)", "1234 567890");
        testValidation("Test 5: Null Value", null);
    }
}
