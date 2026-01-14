package com.assignment1;

public class StringOperations {
    public static void main(String[] args) {

        String s = "  Hello World  ";

        System.out.println(s.length());
        System.out.println(s.isEmpty());
        System.out.println(s.charAt(1));
        System.out.println(s.toString());
        System.out.println(s.equals("Hello"));
        System.out.println(s.compareTo("Hello"));
        System.out.println(s.contains("World"));
        System.out.println(s.indexOf('o'));
        System.out.println(s.lastIndexOf('o'));
        System.out.println(s.startsWith("  He"));
        System.out.println(s.endsWith("ld  "));
        System.out.println(s.matches(".*World.*"));
        System.out.println(s.substring(2, 7));
        System.out.println(s.toLowerCase());
        System.out.println(s.trim());
        System.out.println(s.replace("World", "Java"));

        String[] parts = s.split(" ");
        System.out.println(String.join("-", parts));

        int num = 100;
        System.out.println(String.valueOf(num));
    }
}

