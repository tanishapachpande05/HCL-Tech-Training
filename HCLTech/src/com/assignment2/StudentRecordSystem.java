package com.assignment2;

import java.util.*;
import java.util.regex.Pattern;

interface StudentOperations {
    void addStudent();
    void displayStudents();
    void removeStudent(int roll);
    void searchStudent(int roll);
}

class Student {
    int roll;
    String name;
    String email;

    Student(int roll, String name, String email) {
        this.roll = roll;
        this.name = name;
        this.email = email;
    }

    void show() {
        System.out.println(roll + "\t" + name + "\t" + email);
    }
}

public class StudentRecordSystem implements StudentOperations {

    List<Student> students = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    // Adding student record
    public void addStudent() {
        try {
            System.out.print("Enter Roll Number: ");
            int roll = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            // Email validation using REGEX
            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
            if (!Pattern.matches(emailRegex, email)) {
                System.out.println("Invalid Email");
                return;
            }

            students.add(new Student(roll, name, email));
            System.out.println("Student Added Successfully");

        } catch (Exception e) {
            System.out.println("Invalid input! Please try again.");
            sc.nextLine();
        }
    }

    // Displaying all students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\nRoll\tName\tEmail");
        for (Student s : students) {
            s.show();
        }
    }

    // Remove student by roll number
    public void removeStudent(int roll) {
        Iterator<Student> it = students.iterator();
        boolean found = false;

        while (it.hasNext()) {
            Student s = it.next();
            if (s.roll == roll) {
                it.remove();
                found = true;
                System.out.println("Student Removed Successfully");
                break;
            }
        }

        if (!found)
            System.out.println("Student not found");
    }

    // Search student by roll number
    public void searchStudent(int roll) {
        for (Student s : students) {
            if (s.roll == roll) {
                System.out.println("\nStudent Found:");
                System.out.println("Roll\tName\tEmail");
                s.show();
                return;
            }
        }
        System.out.println("Student not found");
    }

    // Main method
    public static void main(String[] args) {

        StudentRecordSystem obj = new StudentRecordSystem();
        Scanner sc = new Scanner(System.in);

        Vector<String> menu = new Vector<>();
        menu.add("1. Add Student");
        menu.add("2. Display Students");
        menu.add("3. Remove Student");
        menu.add("4. Search Student");
        menu.add("5. Exit");

        try {
            while (true) {

                System.out.println("\n===== STUDENT RECORD MENU =====");
                for (String m : menu)
                    System.out.println(m);

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        obj.addStudent();
                        break;

                    case 2:
                        obj.displayStudents();
                        break;

                    case 3:
                        System.out.print("Enter Roll Number to Remove: ");
                        int r1 = sc.nextInt();
                        obj.removeStudent(r1);
                        break;

                    case 4:
                        System.out.print("Enter Roll Number to Search: ");
                        int r2 = sc.nextInt();
                        obj.searchStudent(r2);
                        break;

                    case 5:
                        System.out.println("Thank You! Program Ended.");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice");
                }
            }

        } catch (Exception e) {
            System.out.println("Error occurred! Please enter valid input.");
        }
    }
}
