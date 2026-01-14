package com.assignment3;

import java.util.*;

public class HashTableDemo {

    public static void main(String[] args) {

        Hashtable<Integer, String> table1 = new Hashtable<>();
        System.out.println("Constructor 1: " + table1);


        table1.put(1, "Java");
        table1.put(2, "Python");
        table1.put(3, "C++");
        System.out.println("After put(): " + table1);

        table1.putIfAbsent(3, "HTML");
        table1.putIfAbsent(4, "JavaScript");
        System.out.println("After putIfAbsent(): " + table1);

        System.out.println("Get key 2: " + table1.get(2));

        table1.remove(1);
        System.out.println("After remove(): " + table1);

        System.out.println("Contains key 3? " + table1.containsKey(3));

        System.out.println("Contains value Python? " + table1.containsValue("Python"));

        System.out.println("Size of table: " + table1.size());

        System.out.println("Is table empty? " + table1.isEmpty());

        System.out.println("Keys: " + table1.keySet());

        System.out.println("Values: " + table1.values());

        System.out.println("Entries:");
        for (Map.Entry<Integer, String> e : table1.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }

        table1.replace(2, "Python-Updated");
        System.out.println("After replace(): " + table1);

        System.out.print("Using elements(): ");
        Enumeration<String> elements = table1.elements();
        while (elements.hasMoreElements()) {
            System.out.print(elements.nextElement() + " ");
        }
        System.out.println();

        System.out.print("Using keys(): ");
        Enumeration<Integer> keys = table1.keys();
        while (keys.hasMoreElements()) {
            System.out.print(keys.nextElement() + " ");
        }
        System.out.println();

        table1.clear();
        System.out.println("After clear(): " + table1);

        Hashtable<Integer, String> table2 = new Hashtable<>(10);
        System.out.println("Constructor 2 (Initial Capacity): " + table2);

        Hashtable<Integer, String> table3 = new Hashtable<>(16, 0.75f);
        System.out.println("Constructor 3 (Capacity + Load Factor): " + table3);

        Hashtable<Integer, String> table4 = new Hashtable<>(table1);
        System.out.println("Constructor 4 (From Map): " + table4);
    }
}

