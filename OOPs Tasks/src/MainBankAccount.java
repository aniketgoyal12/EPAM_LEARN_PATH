public class MainBankAccount {
    public static void main(String[] args) {

        // Creating a new BankAccount object
        BankAccount account = new BankAccount("Aniket Goyal", "ACC1001");

        // Basic info
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Account Number: " + account.getAccountNo());

        // Initial balance
        System.out.println("\n--- Initial Balance ---");
        account.displayBalance();

        // Test deposit
        System.out.println("\n--- Testing Deposit ---");
        account.deposit(1000);
        account.deposit(500);

        // Test invalid deposit (negative amount)
        System.out.println("\n--- Testing Invalid Deposit ---");
        account.deposit(-200);

        // Test withdraw
        System.out.println("\n--- Testing Withdraw ---");
        account.withdraw(300);

        // Test withdraw more than balance (should fail)
        System.out.println("\n--- Testing Insufficient Balance ---");
        account.withdraw(5000);

        // Test invalid withdraw (negative amount)
        System.out.println("\n--- Testing Invalid Withdraw ---");
        account.withdraw(-100);

        // Final balance check
        System.out.println("\n--- Final Balance ---");
        account.displayBalance();
    }
}