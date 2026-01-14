package com.assignment1;

import java.util.Scanner;

class BankAccount {
    String name;
    int accNo;
    double balance;

    BankAccount(String n, int a, double b) {
        name = n;
        accNo = a;
        balance = b;
    }

    void deposit(double amt) {
        balance += amt;
    }

    void withdraw(double amt) throws Exception {
        if (amt > balance)
            throw new Exception("Insufficient Balance");
        balance -= amt;
    }

    void display() {
        System.out.println(name + " " + accNo + " " + balance);
    }
}

public class BankManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BankAccount acc = new BankAccount("Tanisha", 101, 5000);

        try {
            acc.deposit(2000);
            acc.withdraw(3000);
            acc.display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


