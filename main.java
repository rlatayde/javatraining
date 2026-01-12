package m4_activity1;

public class main {
	  public static void main(String[] args) {
	        // Print a header message
		  BankAccount bnkAcc = new BankAccount();
	        System.out.println("=== Bank Account Name Display ===");

	        // Test a valid account
	        bnkAcc.testCase("ACC-001");

	        // Test an invalid account (triggers exception)
	        bnkAcc.testCase("ACC-999");

	        // Print a completion message
	        System.out.println("\n=== Program completed successfully! ===");
	    }
}
