package com.assignment2;
import java.util.*;
import java.util.regex.*;

interface UniversityStudentOperations {
    void addStudent();
    void displayStudents();
    void removeStudentById();
    void searchStudentById();
    void sortStudentsByMarks();
    void convertHashMapToTreeMap();
    void countStudentsCourseWise();
    void displayAllCourses();
}

public class UniversityManagementSystem implements UniversityStudentOperations {

    /* ========== COLLECTIONS USED ========== */
    List<Student> studentList = new ArrayList<>();
    Vector<Student> studentVector = new Vector<>();
    Stack<Student> studentStack = new Stack<>();

    Set<Student> uniqueStudents = new HashSet<>();
    Set<String> courseSet = new HashSet<>();

    Map<Integer, Student> studentHashMap = new HashMap<>();
    Hashtable<Integer, Student> studentHashtable = new Hashtable<>();

    Scanner sc = new Scanner(System.in);
    Pattern pattern = Pattern.compile("^[A-Za-z ]+$");

    /* ========== INNER STUDENT CLASS ========== */
    static class Student implements Comparable<Student> {
        int id;
        String name;
        String course;
        int marks;

        Student(int id, String name, String course, int marks) {
            this.id = id;
            this.name = name;
            this.course = course;
            this.marks = marks;
        }

        @Override
        public int compareTo(Student s) {
            return Integer.compare(this.marks, s.marks);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student s = (Student) o;
            return id == s.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return id + " | " + name + " | " + course + " | " + marks;
        }
    }

    /* ========== FUNCTION IMPLEMENTATIONS ========== */

    @Override
    public void addStudent() {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            if (!pattern.matcher(name).matches())
                throw new Exception("Invalid name format");

            System.out.print("Enter Course: ");
            String course = sc.nextLine();
            if (!pattern.matcher(course).matches())
                throw new Exception("Invalid course format");

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            Student s = new Student(id, name, course, marks);

            if (!uniqueStudents.add(s)) {
                System.out.println("Duplicate student entry not allowed!");
                return;
            }

            studentList.add(s);
            studentVector.add(s);
            studentStack.push(s);

            studentHashMap.put(id, s);
            studentHashtable.put(id, s);
            courseSet.add(course);

            System.out.println("Student added successfully");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            sc.nextLine();
        }
    }

    @Override
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students available");
            return;
        }
        studentList.forEach(System.out::println);
    }

    @Override
    public void removeStudentById() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student s = studentHashMap.remove(id);
        if (s != null) {
            studentList.remove(s);
            studentVector.remove(s);
            studentStack.remove(s);
            uniqueStudents.remove(s);
            studentHashtable.remove(id);
            System.out.println("Student removed successfully");
        } else {
            System.out.println("Student not found");
        }
    }

    @Override
    public void searchStudentById() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student s = studentHashMap.get(id);
        if (s != null)
            System.out.println(s);
        else
            System.out.println("Student not found");
    }

    @Override
    public void sortStudentsByMarks() {
        Collections.sort(studentList);
        System.out.println("Students sorted by marks");
        displayStudents();
    }

    @Override
    public void convertHashMapToTreeMap() {
        TreeMap<Integer, Student> treeMap = new TreeMap<>(studentHashMap);
        System.out.println("HashMap converted to TreeMap:");
        treeMap.forEach((k, v) -> System.out.println(v));
    }

    @Override
    public void countStudentsCourseWise() {
        Map<String, Integer> countMap = new HashMap<>();

        for (Student s : studentList) {
            countMap.put(s.course, countMap.getOrDefault(s.course, 0) + 1);
        }

        System.out.println("Course-wise student count:");
        countMap.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    @Override
    public void displayAllCourses() {
        System.out.println("Unique Courses:");
        courseSet.forEach(System.out::println);
    }

    /* ========== MAIN METHOD ========== */
    public static void main(String[] args) {

        UniversityManagementSystem obj =
                new UniversityManagementSystem();

        while (true) {
            System.out.println("\n----- UNIVERSITY STUDENT MANAGEMENT SYSTEM -----");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Remove Student by ID");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Convert HashMap to TreeMap");
            System.out.println("7. Count Students Course-wise");
            System.out.println("8. Display All Courses");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            int choice = obj.sc.nextInt();

            switch (choice) {
                case 1 -> obj.addStudent();
                case 2 -> obj.displayStudents();
                case 3 -> obj.removeStudentById();
                case 4 -> obj.searchStudentById();
                case 5 -> obj.sortStudentsByMarks();
                case 6 -> obj.convertHashMapToTreeMap();
                case 7 -> obj.countStudentsCourseWise();
                case 8 -> obj.displayAllCourses();
                case 9 -> {
                    System.out.println("Thank you!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
