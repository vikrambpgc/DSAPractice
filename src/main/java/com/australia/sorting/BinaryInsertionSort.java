package com.australia.sorting;

public class BinaryInsertionSort {

    // Method to perform Binary Insertion Sort
    public static void binaryInsertionSort(int[] arr) {
        // Iterate through the array starting from the second element
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i]; // Store the current element as the key

            // Find the correct position for the key using binary search
            int position = binarySearch(arr, 0, i, key);

            // Shift elements to the right to make space for the key
            for (int j = i; j > position; j--) {
                arr[j] = arr[j - 1];
            }

            // Insert the key at its correct position
            arr[position] = key;
        }
    }

    // Method to perform binary search
    public static int binarySearch(int[] arr, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
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

        binaryInsertionSort(arr);
        System.out.println("Sorted array:");
        printArray(arr);
    }
}
