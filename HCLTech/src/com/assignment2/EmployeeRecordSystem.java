package com.assignment2;

import java.util.*;
import java.util.regex.Pattern;

interface EmployeeOperations {
    void addEmployee();
    void displayEmployees();
    void searchEmployee(int id);
    void removeEmployee(int id);
}

class Employee {
    int empId;
    String name;
    String email;

    Employee(int empId, String name, String email) {
        this.empId = empId;
        this.name = name;
        this.email = email;
    }

    void show() {
        System.out.println(empId + "\t" + name + "\t" + email);
    }
}

public class EmployeeRecordSystem implements EmployeeOperations {

    Map<Integer, Employee> hashMap = new HashMap<>();
    Map<Integer, Employee> hashTable = new Hashtable<>();
    Map<Integer, Employee> treeMap = new TreeMap<>();

    Scanner sc = new Scanner(System.in);

    public void addEmployee() {
        try {
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            String emailRegex =
                    "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

            if (!Pattern.matches(emailRegex, email)) {
                System.out.println("Invalid Email ❌");
                return;
            }

            Employee emp = new Employee(id, name, email);

            hashMap.put(id, emp);
            hashTable.put(id, emp);
            treeMap.put(id, emp);

            System.out.println("Employee Added Successfully ✔");

        } catch (Exception e) {
            System.out.println("Invalid Input! Try again.");
            sc.nextLine();
        }
    }

    public void displayEmployees() {
        if (treeMap.isEmpty()) {
            System.out.println("No employee records found.");
            return;
        }

        System.out.println("\nID\tName\tEmail");
        for (Employee e : treeMap.values()) {
            e.show();
        }
    }

    public void searchEmployee(int id) {
        Employee e = hashMap.get(id);

        if (e != null) {
            System.out.println("\nEmployee Found:");
            System.out.println("ID\tName\tEmail");
            e.show();
        } else {
            System.out.println("Employee not found ❌");
        }
    }

    public void removeEmployee(int id) {
        if (hashMap.remove(id) != null) {
            hashTable.remove(id);
            treeMap.remove(id);
            System.out.println("Employee Removed Successfully ✔");
        } else {
            System.out.println("Employee not found ❌");
        }
    }

    void demonstrateNullSupport() {
        System.out.println("\n--- Null Support Demonstration ---");

        hashMap.put(null, null);
        System.out.println("HashMap allows null key & null value ");

        try {
            hashTable.put(null, null);
        } catch (Exception e) {
            System.out.println("Hashtable does NOT allow null key/value ");
        }

        try {
            treeMap.put(null, null);
        } catch (Exception e) {
            System.out.println("TreeMap does NOT allow null key ");
        }
    }

    // Main method
    public static void main(String[] args) {

        EmployeeRecordSystem obj = new EmployeeRecordSystem();
        Scanner sc = new Scanner(System.in);

        try {
            while (true) {

                System.out.println("\n===== EMPLOYEE RECORD MENU =====");
                System.out.println("1. Add Employee");
                System.out.println("2. Display Employees");
                System.out.println("3. Search Employee");
                System.out.println("4. Remove Employee");
                System.out.println("5. Demonstrate Null Support");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        obj.addEmployee();
                        break;

                    case 2:
                        obj.displayEmployees();
                        break;

                    case 3:
                        System.out.print("Enter Employee ID: ");
                        obj.searchEmployee(sc.nextInt());
                        break;

                    case 4:
                        System.out.print("Enter Employee ID: ");
                        obj.removeEmployee(sc.nextInt());
                        break;

                    case 5:
                        obj.demonstrateNullSupport();
                        break;

                    case 6:
                        System.out.println("Thank You! Program Ended.");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice ");
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurred! Enter valid input.");
        }
    }
}
