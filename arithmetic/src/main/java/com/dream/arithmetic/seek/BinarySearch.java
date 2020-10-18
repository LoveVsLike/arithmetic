package com.dream.arithmetic.seek;

public class BinarySearch {

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return a[mid];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println('a' < 'b');
    }

}
