package m4_activity6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class M4Activity6 {

    @FunctionalInterface
    interface BankTestOperation {
        void execute() throws InvalidAmountException, InsufficientFundsException;
    }

    static class BankAccount {
        // Logger: LoggerFactory.getLogger(M4Activity6.class)
        private static final Logger logger = LoggerFactory.getLogger(M4Activity6.class);

        // Initial balance: ₱10,000
        private double balance = 10_000;

        public double getBalance() {
            return balance;
        }

        // Throws InvalidAmountException and InsufficientFundsException
        public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
            logger.info("Withdrawal requested: ₱{}", amount);

            if (amount < 0) {
                logger.error("Invalid withdrawal amount: ₱{}", amount);
                throw new InvalidAmountException("Withdrawal amount must be non-negative.");
            }

            if (amount > balance) {
                logger.warn("Insufficient funds. Current balance: ₱{}, Requested: ₱{}", balance, amount);
                throw new InsufficientFundsException("Insufficient funds for withdrawal.", balance, amount);
            }

            // Process
            balance -= amount;
            logger.info("Withdrawal completed: ₱{}, New balance: ₱{}", amount, balance);
        }

        // Throws InvalidAmountException
        public void deposit(double amount) throws InvalidAmountException {
            logger.info("Deposit requested: ₱{}", amount);

            if (amount <= 0) {
                logger.error("Invalid deposit amount: ₱{}", amount);
                throw new InvalidAmountException("Deposit amount must be greater than 0.");
            }

            if (amount > 50_000) {
                logger.warn("Large deposit detected (>₱50,000): ₱{}", amount);
            }

            // Process
            balance += amount;
            logger.info("Deposit completed: ₱{}, New balance: ₱{}", amount, balance);
        }
    }


    private static final Logger log = LoggerFactory.getLogger(M4Activity6.class);

    public static void runTest(BankTestOperation operation, String operationName) {
        try {
            operation.execute();
        } catch (InvalidAmountException e) {
            log.error("{} failed due to invalid amount.", operationName, e);
        } catch (InsufficientFundsException e) {
            log.error("{} failed due to insufficient funds (balance=₱{}, requested=₱{}).",
                      operationName, e.getBalance(), e.getRequestedAmount(), e);
        }
    }


    public static void main(String[] args) {
        BankAccount account = new BankAccount();


        // Test 1: Deposit 5000
        runTest(() -> account.deposit(5000), "Deposit");

        // Test 2: Withdraw 3000
        runTest(() -> account.withdraw(3000), "Withdrawal");

        // Test 3: Deposit -500 (invalid)
        runTest(() -> account.deposit(-500), "Deposit");

        // Test 4: Withdraw 20000 (insufficient funds)
        runTest(() -> account.withdraw(20000), "Withdrawal");

        // Test 5: Deposit 60000 (warn but process)
        runTest(() -> account.deposit(60000), "Deposit");

        log.info("Final balance: ₱{}", account.getBalance());
    }
}
