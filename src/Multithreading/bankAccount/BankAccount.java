package Multithreading.bankAccount;

public class BankAccount {
    private int balance = 0 ;

    public BankAccount() {
        this.balance = balance ;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) {
        synchronized (this) {
            if (amount > 0) {
                balance += amount;
            }
        }


    }

    public void withdraw(int amount) {
        synchronized (this) {
            if (balance >= amount && amount > 0) {
                balance -= amount;
            }
        }

    }
}
