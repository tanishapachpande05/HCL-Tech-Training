package com.miniproject3;

import java.util.*;

/* ================= CUSTOM EXCEPTION ================= */
class ValidationException extends Exception {
    public ValidationException(String msg) {
        super(msg);
    }
}

/* ================= STUDENT CLASS ================= */
class Student {
    private int eno;
    private String name;
    private String branch;
    private String sem;
    private double percentage;

    public Student(int eno, String name, String branch, String sem, double percentage) {
        this.eno = eno;
        this.name = name;
        this.branch = branch;
        this.sem = sem;
        this.percentage = percentage;
    }

    public int getEno() {
        return eno;
    }

    public String getBranch() {
        return branch;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String toString() {
        return eno + "\t" + name + "\t" + branch + "\t" + sem + "\t" + percentage;
    }
}

/* ================= MAIN CLASS ================= */
public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void login() {
        String user, pass;
        do {
            System.out.print("Enter Username: ");
            user = sc.next();
            System.out.print("Enter Password: ");
            pass = sc.next();

            if (!user.equals("admin") || !pass.equals("admin123")) {
                System.out.println("Invalid Login. Try Again.\n");
            }
        } while (!user.equals("admin") || !pass.equals("admin123"));

        System.out.println("Login Successful\n");
    }

    static void addStudent() {
        try {
            System.out.print("Enter Eno: ");
            int eno = sc.nextInt();

            for (Student s : students) {
                if (s.getEno() == eno)
                    throw new ValidationException("Student Eno must be UNIQUE");
            }

            System.out.print("Enter Name: ");
            String name = sc.next();

            System.out.print("Enter Branch: ");
            String branch = sc.next();
            if (branch.isEmpty())
                throw new ValidationException("Branch cannot be empty");

            System.out.print("Enter Semester: ");
            String sem = sc.next();
            if (sem.isEmpty())
                throw new ValidationException("Semester cannot be empty");

            System.out.print("Enter Percentage: ");
            double per = sc.nextDouble();
            if (per <= 0)
                throw new ValidationException("Percentage must be POSITIVE");

            students.add(new Student(eno, name, branch, sem, per));
            System.out.println("Student Added Successfully");

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid Input");
            sc.nextLine();
        }
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No Student Records Found");
            return;
        }

        System.out.println("Eno\tName\tBranch\tSem\tPercentage");
        for (Student s : students)
            System.out.println(s);
    }

    static void searchStudent() {
        System.out.print("Enter Eno to Search: ");
        int eno = sc.nextInt();

        for (Student s : students) {
            if (s.getEno() == eno) {
                System.out.println("Student Found:");
                System.out.println("Eno\tName\tBranch\tSem\tPercentage");
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    static void updateBranch() {
        System.out.print("Enter Eno to Update: ");
        int eno = sc.nextInt();

        for (Student s : students) {
            if (s.getEno() == eno) {
                System.out.print("Enter New Branch: ");
                String branch = sc.next();
                s.setBranch(branch);
                System.out.println("Branch Updated");
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    static void deleteStudent() {
        System.out.print("Enter Eno to Delete: ");
        int eno = sc.nextInt();

        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getEno() == eno) {
                it.remove();
                System.out.println("Student Deleted");
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    static void sortStudents() {
        students.sort(Comparator.comparingDouble(Student::getPercentage).reversed());
        System.out.println("Students Sorted by Percentage");
        displayStudents();
    }

    /* ================= MAIN METHOD ================= */
    public static void main(String[] args) {

        login();

        while (true) {
            System.out.println("\n===== STUDENT MANAGEMENT MENU =====");
            System.out.println("1. Add Students");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Students by Eno");
            System.out.println("4. Update Students Branch");
            System.out.println("5. Delete Students by Eno");
            System.out.println("6. Display Sorted Students");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> addStudent();
                case 2 -> displayStudents();
                case 3 -> searchStudent();
                case 4 -> updateBranch();
                case 5 -> deleteStudent();
                case 6 -> sortStudents();
                case 7 -> {
                    System.out.println("Exiting Program...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid Choice");
            }
        }
    }
}

