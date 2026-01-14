package com.miniproject2;

import java.io.*;
import java.util.*;

class Employee implements Comparable<Employee> {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee e) {
        return this.name.compareToIgnoreCase(e.name);
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + department + " | " + salary;
    }

    public String toFileString() {
        return id + "," + name + "," + department + "," + salary;
    }
}

/* ================= MAIN SYSTEM ================= */
public class EmployeeManagementSystem {

    static final String FILE_NAME = "employees.txt";
    static Scanner sc = new Scanner(System.in);

    static List<Employee> empList = new ArrayList<>();
    static Map<Integer, Employee> empMap = new HashMap<>();

    static boolean login() {
        String username = "admin";
        String password = "admin123";

        System.out.print("Username: ");
        String u = sc.next();
        System.out.print("Password: ");
        String p = sc.next();

        if (u.equals(username) && p.equals(password)) {
            System.out.println("Login successful\n");
            return true;
        } else {
            System.out.println("Invalid login credentials");
            return false;
        }
    }

    static void loadFromFile() {
        empList.clear();
        empMap.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                Employee e = new Employee(
                        Integer.parseInt(d[0]),
                        d[1],
                        d[2],
                        Double.parseDouble(d[3])
                );
                empList.add(e);
                empMap.put(e.id, e);
            }
        } catch (IOException ignored) {}
    }

    static void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Employee e : empList) {
                bw.write(e.toFileString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("File error occurred");
        }
    }

    static void addEmployee() {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            if (empMap.containsKey(id))
                throw new Exception("Employee ID must be unique");

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();
            if (dept.isEmpty())
                throw new Exception("Department cannot be empty");

            System.out.print("Enter Salary: ");
            double sal = sc.nextDouble();
            if (sal <= 0)
                throw new Exception("Salary must be positive");

            Employee e = new Employee(id, name, dept, sal);
            empList.add(e);
            empMap.put(id, e);
            saveToFile();

            System.out.println("Employee added successfully");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void displayEmployees() {
        if (empList.isEmpty()) {
            System.out.println("No employees found");
            return;
        }
        empList.forEach(System.out::println);
    }

    static void searchEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        Employee e = empMap.get(id);
        if (e != null)
            System.out.println(e);
        else
            System.out.println("Employee not found");
    }

    static void updateSalary() {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            Employee e = empMap.get(id);
            if (e == null)
                throw new Exception("Employee not found");

            System.out.print("Enter new salary: ");
            double sal = sc.nextDouble();
            if (sal <= 0)
                throw new Exception("Salary must be positive");

            e.salary = sal;
            saveToFile();
            System.out.println("Salary updated successfully");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void deleteEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        Employee e = empMap.remove(id);
        if (e != null) {
            empList.remove(e);
            saveToFile();
            System.out.println("Employee deleted successfully");
        } else {
            System.out.println("Employee not found");
        }
    }

    static void displaySorted() {
        Collections.sort(empList);
        displayEmployees();
    }

    static void displayDepartments() {
        Set<String> departments = new HashSet<>();
        for (Employee e : empList)
            departments.add(e.department);

        System.out.println("Departments:");
        departments.forEach(System.out::println);
    }

    /* ================= MAIN ================= */
    public static void main(String[] args) {

        if (!login()) return;

        loadFromFile();

        while (true) {
            System.out.println("\n---- EMPLOYEE MANAGEMENT SYSTEM ----");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Update Employee Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Display Sorted Employees");
            System.out.println("7. Display Departments");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> addEmployee();
                case 2 -> displayEmployees();
                case 3 -> searchEmployee();
                case 4 -> updateSalary();
                case 5 -> deleteEmployee();
                case 6 -> displaySorted();
                case 7 -> displayDepartments();
                case 8 -> {
                    System.out.println("Thank you!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}

