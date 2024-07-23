package com.australia.search;

public class BinarySearch {

    private int findLeftBound(int[] times, int t) {
        int left = 0, right = times.length - 1;

        while (left<=right) {
            int mid = left + (right - left) / 2;
            if (t < times[mid]) {
                right = mid - 1;
            } else if (times[mid] < t) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        if (left >= times.length) return times.length - 1;
        else if (right >=0) return right;
        else return -1;
    }

    public static void main(String[] args) {
        BinarySearch instance = new BinarySearch();

        int leftBound = instance.findLeftBound(new int[]{3,5,7,9}, 1);
        System.out.println("Left bound: " + leftBound);
    }
}
