package me.nasif.hackerrank.algo.ac;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LarrysArray {

    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        scan = new Scanner(new File("res/HackerRank/LarrysArray.txt"));
//        scan = new Scanner(System.in);

        int t = scan.nextInt();
        while (t-- != 0) {
            int n = scan.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scan.nextInt();
            }

            int inversions = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (a[i] > a[j]) {
                        ++inversions;
                    }
                }
            }

            if (inversions % 2 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }
}
