public class BankAccount {
    private String accountNo;
    private double accountBalance;
    private String accountHolderName;

    BankAccount(String accountHolderName, String accountNo){
        this.accountHolderName = accountHolderName;
        this.accountNo = accountNo;
    }

    public double getAccountBalance(){
        return accountBalance;
    }
    public String getAccountNo(){
        return accountNo;
    }
    public String getAccountHolderName(){
        return accountHolderName;
    }

    public void deposit(double amount){
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive");
            return;
        }
        this.accountBalance += amount;
        System.out.println(amount + " deposited successfully. " + "current balance: " + this.accountBalance);
    }

    public void withdraw(double amount){

        double curr_bal = getAccountBalance();
        if(amount > curr_bal){
            System.out.println("Insufficient Balance");
            return;
        }
        else{

            this.accountBalance -= amount;
            System.out.println(amount + " withdrawn, current balance :" + this.accountBalance);
        }
    }

    public void displayBalance(){
        double curr_bal = getAccountBalance();
        System.out.println(curr_bal);
    }

}
