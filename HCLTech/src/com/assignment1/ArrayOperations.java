package com.assignment1;

import java.util.Scanner;
import java.util.Arrays;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = {10, 20, 30, 40, 50};
        int choice;

        do {
            System.out.println("\n1.Insert 2.Delete 3.Linear Search 4.Binary Search");
            System.out.println("5.Max 6.Count Even/Odd 7.Insertion Sort 8.Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Insertion not supported in fixed array");
                    break;

                case 2:
                    System.out.println("Deletion not supported in fixed array");
                    break;

                case 3:
                    int key = sc.nextInt();
                    for (int i = 0; i < arr.length; i++)
                        if (arr[i] == key)
                            System.out.println("Found at index " + i);
                    break;

                case 4:
                    Arrays.sort(arr);
                    key = sc.nextInt();
                    int index = Arrays.binarySearch(arr, key);
                    System.out.println("Index: " + index);
                    break;

                case 5:
                    int max = arr[0];
                    for (int i : arr)
                        if (i > max) max = i;
                    System.out.println("Max: " + max);
                    break;

                case 6:
                    int even = 0, odd = 0;
                    for (int i : arr)
                        if (i % 2 == 0) even++; else odd++;
                    System.out.println("Even: " + even + " Odd: " + odd);
                    break;

                case 7:
                    for (int i = 1; i < arr.length; i++) {
                        int temp = arr[i], j = i - 1;
                        while (j >= 0 && arr[j] > temp) {
                            arr[j + 1] = arr[j];
                            j--;
                        }
                        arr[j + 1] = temp;
                    }
                    System.out.println("Sorted: " + Arrays.toString(arr));
                    break;
            }
        } while (choice != 8);
    }
}
