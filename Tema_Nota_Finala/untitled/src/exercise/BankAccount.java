package exercise;

public class BankAccount {
    String name;
    double balance;
    private double transactionFee=0.0;

    public void modifyTransactionFee(double amount){this.transactionFee=amount;}
    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void withdraw(double amount) {
        if(balance-amount-transactionFee<0)
            balance=balance;
        else
            balance = balance - amount - transactionFee;
    }
    public String toString(){return name+", $"+balance;}
}