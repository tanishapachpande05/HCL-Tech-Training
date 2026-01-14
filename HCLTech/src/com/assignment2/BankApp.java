package com.assignment2;

interface BankWork {

    void deposit(int amount);

    void withdraw(int amount) throws LowBalanceException;
}

interface CustomerWork {

    void showDetails();
}

class LowBalanceException extends Exception {

    LowBalanceException(String message) {
        super(message);
    }
}


class BankAccount implements BankWork, CustomerWork {

    int accountNo;
    String customerName;
    int balance;

    BankAccount(int accountNo, String customerName, int balance) {
        this.accountNo = accountNo;
        this.customerName = customerName;
        this.balance = balance;
    }

    // deposit method
    public void deposit(int amount) {
        balance = balance + amount;
        System.out.println(amount + " rupees deposited");
    }

    // withdraw method
    public void withdraw(int amount) throws LowBalanceException {

        if (amount > balance) {
            throw new LowBalanceException("Balance kam hai!");
        }

        balance = balance - amount;
        System.out.println(amount + " rupees withdrawn");
    }

    public void showDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account No : " + accountNo);
        System.out.println("Name       : " + customerName);
        System.out.println("Balance    : " + balance);
    }
}


public class BankApp {

    public static void main(String[] args) {

        BankAccount acc = new BankAccount(101, "Rajesh Sahu", 5000);

        acc.showDetails();
        acc.deposit(2000);

        try {
            acc.withdraw(9000);   
        } catch (LowBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            acc.withdraw(3000);
        } catch (LowBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // final details
        acc.showDetails();
    }
}
