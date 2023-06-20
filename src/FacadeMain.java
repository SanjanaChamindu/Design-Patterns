public class FacadeMain {
    public static void main(String[] args) {
        BankAccountFacade newBankAccount = new BankAccountFacade(12345678, 1234);
        newBankAccount.depositCash(1000);
        newBankAccount.withdrawCash(250);
        newBankAccount.withdrawCash(1000);
        newBankAccount.depositCash(1000);

        BankAccountFacade newBankAccount2 = new BankAccountFacade(12345, 4321);
        newBankAccount2.depositCash(20);
    }
}

class WelcomePage{
    public WelcomePage(){
        System.out.println("Hello Customer");
    }
}
class AccountNumberCheck{
    private final int accountNumber = 12345678;
    public int getAccountNumber(){
        return accountNumber;
    }
    public boolean accountActive(int accountNumber){
        return this.accountNumber == accountNumber;
    }
}

class SecurityCodeCheck{
    private final int securityCode = 1234;

    public int getSecurityCode(){
        return securityCode;
    }
    public boolean isCodeCorrect(int securityCode){
        return this.securityCode == securityCode;
    }
}

class Transaction{
    private double cashInAccount = 0;
    public double getCashInAccount(){
        return this.cashInAccount;
    }
    public void increaseBalance(double cashDeposited){
        this.cashInAccount += cashDeposited;
    }
    public void decreaseBalance(double cashWithdrawn){
        this.cashInAccount -= cashWithdrawn;
    }
    public void withdraw(double cashWithdrawn){
        if (this.cashInAccount >= cashWithdrawn){
            this.decreaseBalance(cashWithdrawn);
            System.out.println("Withdraw Completed");
        } else{
            System.out.println("Insufficient Balance :(");
        }
        System.out.println("Balance = " + this.cashInAccount);
    }
    public void deposit(double cashDeposit){
        this.increaseBalance(cashDeposit);
        System.out.println("Deposit Completed");
        System.out.println("Balance = " + this.cashInAccount);
    }

}
class BankAccountFacade{
    private final int accountNumber;
    private final int securityCode;
    WelcomePage welcomePage;
    AccountNumberCheck accountNumberCheck;
    SecurityCodeCheck securityCodeCheck;
    Transaction transaction;
    boolean validAccount;
    public BankAccountFacade(int accountNumber, int securityCode){
        this.accountNumber = accountNumber;
        this.securityCode = securityCode;
        welcomePage = new WelcomePage();
        accountNumberCheck = new AccountNumberCheck();
        securityCodeCheck = new SecurityCodeCheck();
        transaction = new Transaction();
        validAccount = accountNumberCheck.accountActive(this.accountNumber) &&
                       securityCodeCheck.isCodeCorrect(this.securityCode);
    }
    public int getAccountNumber(){
        return this.accountNumber;
    }
    public int getSecurityCode(){
        return this.securityCode;
    }
    public void withdrawCash(double amount){
        if (validAccount){
            transaction.withdraw(amount);
        } else{
            System.out.println("Incorrect username or password");
        }
    }
    public void depositCash(double amount){
        if(validAccount){
            transaction.deposit(amount);
        } else{
            System.out.println("Incorrect username or password");
        }
    }
}