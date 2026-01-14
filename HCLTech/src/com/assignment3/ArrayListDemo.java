package com.assignment3;

import java.util.*;

public class ArrayListDemo {

    public static void main(String[] args) {

        ArrayList<String> list1 = new ArrayList<>();
        System.out.println("Constructor 1: " + list1);

        ArrayList<String> list2 = new ArrayList<>(5);
        System.out.println("Constructor 2 (Initial Capacity): " + list2);


        list1.add("Java");
        list1.add("Python");
        list1.add("C++");
        System.out.println("After add(): " + list1);

        list1.add(1, "C");
        System.out.println("After add(index, element): " + list1);

        list2.addAll(list1);
        System.out.println("After addAll(): " + list2);

        System.out.println("Element at index 2: " + list1.get(2));

        list1.set(2, "JavaScript");
        System.out.println("After set(): " + list1);

        list1.remove(1);
        System.out.println("After remove(index): " + list1);

        list1.remove("C++");
        System.out.println("After remove(object): " + list1);

        System.out.println("Contains Java? " + list1.contains("Java"));

        System.out.println("Size of list: " + list1.size());

        System.out.println("Is list empty? " + list1.isEmpty());

        System.out.println("Index of Java: " + list1.indexOf("Java"));

        list1.add("Java");
        System.out.println("Last index of Java: " + list1.lastIndexOf("Java"));

        System.out.print("Using Iterator: ");
        Iterator<String> it = list1.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        Object[] arr = list1.toArray();
        System.out.println("Array using toArray(): " + Arrays.toString(arr));

        list1.clear();
        System.out.println("After clear(): " + list1);

        ArrayList<String> list3 = new ArrayList<>(list2);
        System.out.println("Constructor 3 (Collection): " + list3);
    }
}

