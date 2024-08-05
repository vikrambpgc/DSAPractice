package com.australia.binarysearchtree;

public class BinarySearchFloor {

    // Method to find the floor of a target in an array
    public static int binarySearchFloor(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int floor = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] < target) {
                floor = arr[mid];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return floor;
    }

    // Method to print the result
    public static void printResult(int[] arr, int target) {
        int floor = binarySearchFloor(arr, target);
        if (floor == -1) {
            System.out.println("No floor found for target " + target);
        } else {
            System.out.println("Floor of " + target + " is " + floor);
        }
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 5;
        printResult(arr, target);

        target = 10;
        printResult(arr, target);

        target = 0;
        printResult(arr, target);
    }
}
