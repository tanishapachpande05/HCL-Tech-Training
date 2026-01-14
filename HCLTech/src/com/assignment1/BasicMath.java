package com.assignment1;

import java.util.Scanner;

public class BasicMath {

    static int add(int a, int b) { return a + b; }
    static int subtract(int a, int b) { return a - b; }
    static int multiply(int a, int b) { return a * b; }
    static int divide(int a, int b) { return a / b; }
    static int remainder(int a, int b) { return a % b; }
    static int square(int a) { return a * a; }
    static int cube(int a) { return a * a * a; }
    static int absolute(int a) { return Math.abs(a); }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("Addition: " + add(a, b));
        System.out.println("Subtraction: " + subtract(a, b));
        System.out.println("Multiplication: " + multiply(a, b));
        System.out.println("Division: " + divide(a, b));
        System.out.println("Remainder: " + remainder(a, b));
        System.out.println("Square of a: " + square(a));
        System.out.println("Cube of a: " + cube(a));
        System.out.println("Absolute of a: " + absolute(a));
    }
}

