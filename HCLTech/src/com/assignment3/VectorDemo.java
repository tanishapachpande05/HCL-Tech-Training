package com.assignment3;

import java.util.*;

public class VectorDemo {

    public static void main(String[] args) {

        Vector<String> v1 = new Vector<>();
        System.out.println("Constructor 1: " + v1);

        Vector<String> v2 = new Vector<>(5);
        System.out.println("Constructor 2 (Initial Capacity): " + v2);

        v1.add("Java");
        v1.add("Python");
        v1.add("C++");
        System.out.println("After add(): " + v1);

        v1.addElement("C");
        System.out.println("After addElement(): " + v1);

        v1.add(1, "HTML");
        System.out.println("After add(index, element): " + v1);

        v2.addAll(v1);
        System.out.println("After addAll(): " + v2);

        System.out.println("Element at index 2: " + v1.get(2));

        v1.set(2, "JavaScript");
        System.out.println("After set(): " + v1);

        v1.remove(1);
        System.out.println("After remove(index): " + v1);

        v1.remove("C++");
        System.out.println("After remove(object): " + v1);

        System.out.println("Contains Java? " + v1.contains("Java"));

        System.out.println("Size of Vector: " + v1.size());

        System.out.println("Capacity of Vector: " + v1.capacity());

        System.out.println("First Element: " + v1.firstElement());

        System.out.println("Last Element: " + v1.lastElement());

        System.out.print("Using Enumeration: ");
        Enumeration<String> e = v1.elements();
        while (e.hasMoreElements()) {
            System.out.print(e.nextElement() + " ");
        }
        System.out.println();

        v1.clear();
        System.out.println("After clear(): " + v1);

        Vector<String> v3 = new Vector<>(10, 5);
        System.out.println("Constructor 3 (Capacity + Increment): " + v3);

        Vector<String> v4 = new Vector<>(v2);
        System.out.println("Constructor 4 (Collection): " + v4);
    }
}

