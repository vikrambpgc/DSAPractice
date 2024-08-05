package com.australia.sorting;

public class MergeSort {

    // Method to perform Merge Sort
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;

            // Divide the array into two halves
            int[] left = new int[mid];
            int[] right = new int[arr.length - mid];

            // Copy data into the left and right arrays
            for (int i = 0; i < mid; i++) {
                left[i] = arr[i];
            }
            for (int i = mid; i < arr.length; i++) {
                right[i - mid] = arr[i];
            }

            // Recursively sort the left and right arrays
            mergeSort(left);
            mergeSort(right);

            // Merge the sorted left and right arrays
            merge(arr, left, right);
        }
    }

    // Method to merge two sorted arrays
    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0; // Index for the left array
        int j = 0; // Index for the right array
        int k = 0; // Index for the merged array

        // Merge smaller elements first
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements from the left array
        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        // Copy any remaining elements from the right array
        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
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

        mergeSort(arr);
        System.out.println("Sorted array:");
        printArray(arr);
    }
}