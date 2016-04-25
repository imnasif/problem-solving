package me.nasif.templates;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Arrays.sort(a);
        System.out.println(getIndexOf(a, -12));
    }

    static int getIndexOf(int[] a, int n) {
        int l = 0, r = a.length - 1;
        int m = (int) Math.floor((l + r) / 2);
        while (true) {
            if (l >= r || a[l] > n || a[r] < n) {
                return -1;
            }
            if (a[m] == n) {
                return m;
            }

            if (a[m] < n) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

    }

}
