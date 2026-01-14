package com.assignment3;

import java.util.*;

public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<Integer, String> map1 = new HashMap<>();
        System.out.println("Constructor 1: " + map1);


        map1.put(1, "Java");
        map1.put(2, "Python");
        map1.put(3, "C++");
        System.out.println("After put(): " + map1);

        map1.putIfAbsent(3, "HTML");
        map1.putIfAbsent(4, "JavaScript");
        System.out.println("After putIfAbsent(): " + map1);

        System.out.println("Get key 2: " + map1.get(2));

        map1.remove(1);
        System.out.println("After remove(): " + map1);

        System.out.println("Contains key 3? " + map1.containsKey(3));

        System.out.println("Contains value Python? " + map1.containsValue("Python"));

        System.out.println("Size of map: " + map1.size());

        System.out.println("Is map empty? " + map1.isEmpty());

        System.out.println("Keys: " + map1.keySet());

        System.out.println("Values: " + map1.values());

        System.out.println("Entries:");
        for (Map.Entry<Integer, String> e : map1.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }

        map1.replace(2, "Python-Updated");
        System.out.println("After replace(): " + map1);

        System.out.println("Using forEach():");
        map1.forEach((k, v) -> System.out.println(k + " -> " + v));

        HashMap<Integer, String> mapClone =
                (HashMap<Integer, String>) map1.clone();
        System.out.println("Cloned Map: " + mapClone);

        map1.clear();
        System.out.println("After clear(): " + map1);

        HashMap<Integer, String> map2 = new HashMap<>(10);
        System.out.println("Constructor 2 (Initial Capacity): " + map2);

        HashMap<Integer, String> map3 = new HashMap<>(16, 0.75f);
        System.out.println("Constructor 3 (Capacity + Load Factor): " + map3);

        HashMap<Integer, String> map4 = new HashMap<>(mapClone);
        System.out.println("Constructor 4 (From Map): " + map4);
    }
}

