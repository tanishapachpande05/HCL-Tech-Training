package com.assignment3;

import java.util.*;

public class TreeMapDemo {

    public static void main(String[] args) {

        TreeMap<Integer, String> map1 = new TreeMap<>();
        System.out.println("Constructor 1: " + map1);


        // 1. put(K, V)
        map1.put(3, "Java");
        map1.put(1, "Python");
        map1.put(2, "C++");
        System.out.println("After put(): " + map1);

        // 2. putIfAbsent(K, V)
        map1.putIfAbsent(2, "HTML");
        map1.putIfAbsent(4, "JavaScript");
        System.out.println("After putIfAbsent(): " + map1);

        // 3. get(K)
        System.out.println("Get key 2: " + map1.get(2));

        // 4. remove(K)
        map1.remove(1);
        System.out.println("After remove(): " + map1);

        // 5. containsKey(K)
        System.out.println("Contains key 3? " + map1.containsKey(3));

        // 6. containsValue(V)
        System.out.println("Contains value Java? " + map1.containsValue("Java"));

        // 7. size()
        System.out.println("Size of TreeMap: " + map1.size());

        // 8. isEmpty()
        System.out.println("Is TreeMap empty? " + map1.isEmpty());

        // 9. firstKey()
        System.out.println("First key: " + map1.firstKey());

        // 10. lastKey()
        System.out.println("Last key: " + map1.lastKey());

        // 11. higherKey(K)
        System.out.println("Higher key than 2: " + map1.higherKey(2));

        // 12. lowerKey(K)
        System.out.println("Lower key than 3: " + map1.lowerKey(3));

        // 13. keySet()
        System.out.println("Keys: " + map1.keySet());

        // 14. values()
        System.out.println("Values: " + map1.values());

        // 15. entrySet()
        System.out.println("Entries:");
        for (Map.Entry<Integer, String> e : map1.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }

        TreeMap<Integer, String> map2 =
                new TreeMap<>(Collections.reverseOrder());
        map2.putAll(map1);
        System.out.println("Constructor 2 (Comparator): " + map2);

        TreeMap<Integer, String> map3 = new TreeMap<>(map1);
        System.out.println("Constructor 3 (From Map): " + map3);

        SortedMap<Integer, String> sm = new TreeMap<>();
        sm.put(10, "A");
        sm.put(20, "B");

        TreeMap<Integer, String> map4 = new TreeMap<>(sm);
        System.out.println("Constructor 4 (From SortedMap): " + map4);
    }
}

