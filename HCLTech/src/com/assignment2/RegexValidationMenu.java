package com.assignment2;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexValidationMenu {

    static boolean validate(String input, String regex) {
        return Pattern.matches(regex, input);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        try {
            while (true) {

                // Menu
                System.out.println("\n===== INPUT VALIDATION MENU =====");
                System.out.println("1. Validate Mobile Number");
                System.out.println("2. Validate Email ID");
                System.out.println("3. Validate Username");
                System.out.println("4. Validate Password");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {

                    case 1:
                        System.out.print("Enter Mobile Number: ");
                        String mobile = sc.nextLine();

                        String mobileRegex = "[6-9][0-9]{9}";

                        if (validate(mobile, mobileRegex))
                            System.out.println("Welcome! Valid Mobile Number");
                        else
                            System.out.println("Invalid Mobile Number");
                        break;

                    case 2:
                        System.out.print("Enter Email ID: ");
                        String email = sc.nextLine();

                        String emailRegex =
                                "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

                        if (validate(email, emailRegex))
                            System.out.println("Welcome! Valid Email ID");
                        else
                            System.out.println("Invalid Email ID");
                        break;

                    case 3:
                        System.out.print("Enter Username: ");
                        String username = sc.nextLine();

                        String userRegex = "[a-zA-Z0-9]{5,}";

                        if (validate(username, userRegex))
                            System.out.println("Welcome! Valid Username");
                        else
                            System.out.println("Invalid Username");
                        break;

                    case 4: 
                        System.out.print("Enter Password: ");
                        String password = sc.nextLine();

                        String passRegex =
                                "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}";

                        if (validate(password, passRegex))
                            System.out.println("Welcome! Strong Password");
                        else
                            System.out.println("Invalid Password");
                        break;

                    case 5:
                        System.out.println("Thank you! Program exited.");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }

        } catch (Exception e) {
            // Exception handling
            System.out.println("Error: Please enter valid input.");
        } finally {
            sc.close();
        }
    }
}