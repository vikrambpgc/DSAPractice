package com.australia.sorting;

public class InsertionSort {

    // Method to perform Insertion Sort
    public static void insertionSort(int[] arr) {
        // Iterate through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // Store the current element as the key
            int j = i - 1; // Initialize the index for comparison

            // Compare the key with the previous elements and shift if necessary
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // Shift the element to the right
                j--; // Move to the previous element
            }

            // Insert the key at its correct position
            arr[j + 1] = key;
        }
    }

    // Method to print the sorted array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 3, 1, 6, 4};
        System.out.println("Original array:");
        printArray(arr);

        insertionSort(arr);
        System.out.println("Sorted array:");
        printArray(arr);
    }
}
