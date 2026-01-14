package com.miniproject1;

import java.io.*;
import java.util.*;

abstract class BankAccount {

    private int accountNumber;
    private String accountHolder;
    protected double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    // Method Overloading
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void deposit(double amount, String mode) {
        balance += amount;
        System.out.println("Deposited: " + amount + " via " + mode);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public void showBalance() {
        System.out.println("Current Balance: " + balance);
    }

    public void displayAccountDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder Name: " + accountHolder);
        System.out.println("Balance: " + balance);
    }

    public abstract double calculateInterest();

    public String toFileString() {
        return accountNumber + "," + accountHolder + "," + balance + "," + this.getClass().getSimpleName();
    }
}


class SavingsAccount extends BankAccount {

    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.04;
    }
}

class CurrentAccount extends BankAccount {

    public CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.02;
    }
}

/* ========== MAIN APPLICATION CLASS ========== */
public class BankManagementSystem {

    static final String FILE_NAME = "accounts.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        BankAccount account = null;

        while (true) {
            System.out.println("\n----- BANK MANAGEMENT SYSTEM -----");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Balance Enquiry");
            System.out.println("5. Display Account Details");
            System.out.println("6. Calculate Interest");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1 -> {
                    account = createAccount();
                    saveToFile(account);
                }

                case 2 -> {
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    account.deposit(amt, "Cash");
                    saveToFile(account);
                }

                case 3 -> {
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    account.withdraw(amt);
                    saveToFile(account);
                }

                case 4 -> account.showBalance();

                case 5 -> account.displayAccountDetails();

                case 6 -> {
                    System.out.println("Interest: " + account.calculateInterest());
                }

                case 7 -> {
                    System.out.println("Thank you for banking with us!");
                    System.exit(0);
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }

    public static BankAccount createAccount() {

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        System.out.print("Account Type (1-Savings / 2-Current): ");
        int type = sc.nextInt();

        if (type == 1)
            return new SavingsAccount(accNo, name, bal);
        else
            return new CurrentAccount(accNo, name, bal);
    }

    public static void saveToFile(BankAccount acc) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(acc.toFileString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("File error");
        }
    }
}

